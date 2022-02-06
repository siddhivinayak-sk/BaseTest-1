package baseimage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang.StringUtils;

import com.github.jaiimageio.plugins.tiff.BaselineTIFFTagSet;
import com.github.jaiimageio.plugins.tiff.TIFFDirectory;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;

public final class ImageUtil {

	private ImageUtil() {
	}

	private static final com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi tiffspi;

	static {
		tiffspi = new com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi();
	}

	public static void convert(InputStream inputStream, OutputStream outputStream, boolean enableCompression,
			String compressionType, int resolution, Logger logger) {
		try {
			logger.info("ImageUtil: Start");
			ImageWriter writer = tiffspi.createWriterInstance();
			logger.info("ImageUtil: Writer created");
			ImageWriteParam writerParams = writer.getDefaultWriteParam();
			logger.info("ImageUtil: Writer Param created");
			if (enableCompression) {
				logger.info("ImageUtil: Setting comparasion parameters - with enable");
				writerParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				writerParams.setCompressionType(compressionType);
				writerParams.setCompressionQuality(1.0f);
			} else {
				logger.info("ImageUtil: Setting comparasion parameters - with disable");
				writerParams.setCompressionMode(ImageWriteParam.MODE_COPY_FROM_METADATA);
			}
			writerParams
					.setDestinationType(ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_BYTE_BINARY));
			logger.info("ImageUtil: Destination type created");
			// Create metadata for Java IO ImageWriter
			IIOMetadata metadata = createMetadata(writer, writerParams, resolution);
			logger.info("ImageUtil: Metadata created");

			BufferedImage image = ImageIO.read(inputStream);
			logger.info("ImageUtil: BufferedImage created");

			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_BINARY);
			logger.info("ImageUtil: BufferedImage height width set");
			Graphics2D graphic = result.createGraphics();
			logger.info("ImageUtil: Graphics 2D Init");
			graphic.drawImage(image, 0, 0, Color.WHITE, null);
			logger.info("ImageUtil: Graphics 2D Draw");
			ImageOutputStream ios = null;
			try {
				logger.info("ImageUtil: Writing started");
				ios = ImageIO.createImageOutputStream(outputStream);
				logger.info("ImageUtil: OutputStream Set");
				writer.setOutput(ios);
				logger.info("ImageUtil: IIOImage Write Start");
				writer.write(null, new IIOImage(result, null, metadata), writerParams);
				logger.info("ImageUtil: IIOImage Write end");
			} catch (Exception ex) {
				logger.log(Level.SEVERE, "Exception while writing image", ex);
			} finally {
				ios.close();
				logger.info("Writer Closed");
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception Generic IOException", e);
		}
	}

	public static String convert(String source, String destination, boolean enableCompression, String compressionType,
			int resolution) {
		try {
			File input = new File(source);
			com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi tiffspi = new com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi();
			ImageWriter writer = tiffspi.createWriterInstance();
			ImageWriteParam writerParams = writer.getDefaultWriteParam();
			if (enableCompression) {
				writerParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				writerParams.setCompressionType(compressionType);
				writerParams.setCompressionQuality(1.0f);
			} else {
				writerParams.setCompressionMode(ImageWriteParam.MODE_COPY_FROM_METADATA);
			}
			writerParams
					.setDestinationType(ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_BYTE_BINARY));
			// Create metadata for Java IO ImageWriter
			IIOMetadata metadata = createMetadata(writer, writerParams, resolution);

			BufferedImage image = ImageIO.read(input);
			String fileNameWithOutExt = input.getName().replaceFirst("[.][^.]+$", "");
			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_BINARY);

			Graphics2D graphic = result.createGraphics();
			graphic.drawImage(image, 0, 0, Color.WHITE, null);
			File outputFile = new File(destination + File.separator + fileNameWithOutExt + ".tif");
			ImageOutputStream ios = null;
			try {
				ios = ImageIO.createImageOutputStream(outputFile);
				writer.setOutput(ios);
				writer.write(null, new IIOImage(result, null, metadata), writerParams);
			} catch (Exception ex) {
				// Intentionally kept blank
			} finally {
				ios.close();
			}
			return outputFile.getAbsolutePath();
		} catch (IOException e) {
			// Intentionally kept blank
		}
		return StringUtils.EMPTY;
	}

	private static IIOMetadata createMetadata(ImageWriter writer, ImageWriteParam writerParams, int resolution)
			throws IIOInvalidTreeException {
		ImageTypeSpecifier type = writerParams.getDestinationType();
		IIOMetadata meta = writer.getDefaultImageMetadata(type, writerParams);
		TIFFDirectory dir = TIFFDirectory.createFromMetadata(meta);
		BaselineTIFFTagSet base = BaselineTIFFTagSet.getInstance();
		// add resolution dpi
		TIFFTag tagXRes = base.getTag(BaselineTIFFTagSet.TAG_X_RESOLUTION);
		TIFFTag tagYRes = base.getTag(BaselineTIFFTagSet.TAG_Y_RESOLUTION);
		TIFFField fieldXRes = new TIFFField(tagXRes, TIFFTag.TIFF_RATIONAL, 1, new long[][] { { resolution, 1 } });
		TIFFField fieldYRes = new TIFFField(tagYRes, TIFFTag.TIFF_RATIONAL, 1, new long[][] { { resolution, 1 } });
		dir.addTIFFField(fieldXRes);
		dir.addTIFFField(fieldYRes);
		// add resolution unit
		TIFFTag tagResType = base.getTag(BaselineTIFFTagSet.TAG_RESOLUTION_UNIT);
		TIFFField tiffFieldRes = new TIFFField(tagResType, 2);
		dir.addTIFFField(tiffFieldRes);
		return dir.getAsMetadata();
	}

	public static String prepareNotificationFilePath(Map<String, Object> yamlProperties, String path, Logger logger) {
		String unprocessedFilePath = "";
		try {
			logger.info("NotificationFile: Start creation");
			String unprocessedFolder = (String) yamlProperties.get("ocrUnprocessedDir");
			logger.info("NotificationFile: unprocessedFolder Obtained");
			String pathSpliter = (String) yamlProperties.get("pathSpliter");
			logger.info("NotificationFile: pathSpliter Obtained");
			String customPathSpliter = (String) yamlProperties.get("customPathSpliter");
			logger.info("NotificationFile: customPathSpliter Obtained");
			String imagePath = path.replace(pathSpliter, customPathSpliter);
			logger.info("NotificationFile: image path replaced from" + pathSpliter + " to " + customPathSpliter);
			String extension = (String) yamlProperties.get("notificationFileExtension");
			logger.info("NotificationFile: FileName extension Obtained");
			unprocessedFilePath = StringUtils
					.join(new String[] { unprocessedFolder, StringUtils.join(new String[] {imagePath}, extension) }, pathSpliter);
			logger.info("NotificationFile: Final Unprocessed File Path prepared");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Exception Occurred in Notification file path creation", ex);
		}
		return unprocessedFilePath;
	}
}
