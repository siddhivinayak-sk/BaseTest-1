package image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.imgscalr.Scalr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.jaiimageio.plugins.tiff.BaselineTIFFTagSet;
import com.github.jaiimageio.plugins.tiff.TIFFDirectory;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;

import net.sf.image4j.util.ConvertUtil;

public class TifTest {

	private static Logger LOGGER = Logger.getLogger(TifTest.class.getName());
	
	public static void main(String...args) throws Exception {
		
		
		Map<String, Object> configuration = new HashMap<String, Object>();
		configuration.put("grayOutputCompression", "JPEG");
		configuration.put("btFOutputCompression", "CCITT T.6");
		configuration.put("btBOutputCompression", "CCITT T.6");
		configuration.put("grayCompression", true);
		configuration.put("btFCompression", true);
		configuration.put("btBCompression", true);
		configuration.put("grayCompressionQuality", 0.85f);
		configuration.put("btFCompressionQuality", 0.85f);
		configuration.put("btBCompressionQuality", 0.85f);
		configuration.put("grayDpi", 50);
		configuration.put("btFDpi", 240);
		configuration.put("btBDpi", 240);
		configuration.put("grayMHeight", 350);
		configuration.put("grayMWidth", 700);
		configuration.put("btFMHeight", 700);
		configuration.put("btFMWidth", 1400);
		configuration.put("btBMHeight", 700);
		configuration.put("btBMWidth", 1400);
		configuration.put("grayBitDepth", 16);
		configuration.put("btFBitDepth", 1);
		configuration.put("btBBitDepth", 1);
		craeteImageSetSingle("C:\\sandeep\\temp\\20211126\\2\\", configuration);
		
		
		
		//split("C:\\sandeep\\temp\\20210608\\images\\2020112574630013090020001.IMG.tif", "C:\\sandeep\\temp\\20210608\\images\\extracted");
		//jpeg("C:\\sandeep\\temp\\20210608\\images\\extracted\\gray\\70ee3a8f-49d4-4c86-98d5-8e07a280766b_F.tif", "C:\\sandeep\\temp\\20210608\\images\\extracted\\gray\\2.jpg");
	}
	
	private static void jpeg(String inFile, String outFile) throws IOException {
		File input = new File(inFile);
	    BufferedImage image = ImageIO.read(input);
	    File compressedImageFile = new File(outFile);
	    OutputStream os = new FileOutputStream(compressedImageFile);
	    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
	    ImageWriter writer = (ImageWriter) writers.next();
	    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	    writer.setOutput(ios);
	    ImageWriteParam param = writer.getDefaultWriteParam();
	    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	    param.setCompressionQuality(0.05f);  // Change the quality value you prefer
	    writer.write(null, new IIOImage(image, null, null), param);
	    os.close();
	    ios.close();
	    writer.dispose();		
	}
	
	public static void craeteImageSetSingle(String sourcePath, Map<String, Object> configuration) throws IOException {
		File inputFileDir = new File(sourcePath);
		for(File file:inputFileDir.listFiles()) {
			if(file.isFile() && (file.getName().toLowerCase().endsWith(".jpg"))) {
				ImageS grayF = new ImageS(file.getAbsolutePath(), true, true);
				ImageSet imageSet = new ImageSet(grayF, null, null);
				prepareFiles(imageSet, sourcePath + "/C" + file.getName(), configuration);
			}
		}
	}

	
	public static void craeteImageSet(String sourcePath, Map<String, Object> configuration) throws IOException {
		String graySourcePath = sourcePath + "/gray";
		String btSourcePath = sourcePath + "/bitonal";
		File inputFile = new File(graySourcePath);
		for(File tmp:inputFile.listFiles()) {
			if(tmp.isFile() && tmp.getName().contains("_F.")) {
				ImageS grayF = new ImageS(tmp.getAbsolutePath(), true, true);
				ImageS btF = new ImageS(btSourcePath + "/" +  tmp.getName(), false, true);
				ImageS btB = new ImageS(btSourcePath + "/" + tmp.getName().replace("_F.", "_B."), false, false);
				ImageSet imageSet = new ImageSet(grayF, btF, btB);
				prepareFiles(imageSet, sourcePath + "/" + tmp.getName(), configuration);
			}
		}
	}
	
	public static List<ImageS> prepareFiles(ImageSet imageSet, String singleFile, Map<String, Object> configuration) throws IOException {
		List<ImageS> images = new ArrayList<>();
		images.add(imageSet.getGrayF());
		//images.add(imageSet.getBtF());
		//images.add(imageSet.getBtB());
		singleTiff(images, singleFile, configuration);
		return images;
	}

	public static void singleTiff(List<ImageS> inputSource, String singleFile, Map<String, Object> configuration) throws IOException {
		try {
			String grayOutputCompression = (String)configuration.get("grayOutputCompression");
			String btFOutputCompression = (String)configuration.get("btFOutputCompression");
			String btBOutputCompression = (String)configuration.get("btBOutputCompression");
			boolean grayCompression = (Boolean)configuration.get("grayCompression");
			boolean btFCompression = (Boolean)configuration.get("btFCompression");
			boolean btBCompression = (Boolean)configuration.get("btBCompression");
			float grayCompressionQuality = (Float)configuration.get("grayCompressionQuality");
			float btFCompressionQuality = (Float)configuration.get("btFCompressionQuality");
			float btBCompressionQuality = (Float)configuration.get("btBCompressionQuality");
			int grayDpi = (Integer)configuration.get("grayDpi");
			int btFDpi = (Integer)configuration.get("btFDpi");
			int btBDpi = (Integer)configuration.get("btBDpi");
			int grayBitDepth = (Integer)configuration.get("grayBitDepth");
			int btFBitDepth = (Integer)configuration.get("btFBitDepth");
			int btBBitDepth = (Integer)configuration.get("btBBitDepth");
			
			int grayMHeight = (int)configuration.get("grayMHeight");
			int grayMWidth = (int)configuration.get("grayMWidth");
			int btFMHeight = (int)configuration.get("btFMHeight");
			int btFMWidth = (int)configuration.get("btFMWidth");
			int btBMHeight = (int)configuration.get("btBMHeight");
			int btBMWidth = (int)configuration.get("btBMWidth");
			
    		ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();
    		File outputFile = new File(singleFile);
    		ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile);
    		ios.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            writer.setOutput(ios);
            writer.prepareWriteSequence(getStreamIIOMetadata(writer, writer.getDefaultWriteParam()));
            //writer.prepareWriteSequence(null);
            for(ImageS source:inputSource) {
            	System.out.println(source.getFileName());
            	BufferedImage input = ImageIO.read(new File(source.getFileName()));
            	if(source.isGray()) {
            		input = processImage(input, grayOutputCompression, grayBitDepth, grayMHeight, grayMWidth);
            		ImageWriteParam writeParam = writer.getDefaultWriteParam();
            		IIOMetadata md = getIIOMetadata(writer, writeParam, grayCompression, grayOutputCompression, grayCompressionQuality, grayDpi, input, outputFile.getName());
            		List<BufferedImage> thumbnails = new ArrayList<>();
            		thumbnails.add(getThumbnail(input, 10));
            		writer.writeToSequence(new IIOImage(input, null, md), writeParam);
            	}
            	else if(source.isFront()) {
            		input = processImage(input, btFOutputCompression, btFBitDepth, btFMHeight, btFMWidth);
            		ImageWriteParam writeParam1 = writer.getDefaultWriteParam();
            		IIOMetadata md1 = getIIOMetadata(writer, writeParam1, btFCompression, btFOutputCompression, btFCompressionQuality, btFDpi, input, outputFile.getName());
            		List<BufferedImage> thumbnails = new ArrayList<>();
            		thumbnails.add(getThumbnail(input, 10));
            		writer.writeToSequence(new IIOImage(input, thumbnails, md1), writeParam1);
            	}
            	else if(!source.isFront()) {
            		input = processImage(input, btBOutputCompression, btBBitDepth, btBMHeight, btBMWidth);
            		ImageWriteParam writeParam2 = writer.getDefaultWriteParam();
            		IIOMetadata md2 = getIIOMetadata(writer, writeParam2, btBCompression, btBOutputCompression, btBCompressionQuality, btBDpi, input, outputFile.getName());
            		List<BufferedImage> thumbnails = new ArrayList<>();
            		thumbnails.add(getThumbnail(input, 10));
            		writer.writeToSequence(new IIOImage(input, thumbnails, md2), writeParam2);
            	}
            }
            writer.endWriteSequence();
            writer.dispose();
            ios.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static BufferedImage processImage(BufferedImage input, String compression, int bitDepth, int height, int width) {
		//input = downScale(height, width, input);
		input = setImageColorBitDepth(input, bitDepth);
		if(compression.equalsIgnoreCase("JPEG")) {
			input = normalizeImage(input);
		}
		return input;
	}
	
	private static BufferedImage getThumbnail(BufferedImage source, int percent) {
		int width = (source.getWidth() * percent)/100;
		int height = (source.getHeight() * percent)/100;
		BufferedImage thumbnNailImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = thumbnNailImage.createGraphics();
	    g2.fillRect(0, 0, width, height);
	    double xScale = (double) width / source.getWidth();
	    double yScale = (double) height / source.getHeight();
	    double scale = Math.min(xScale, yScale);
	    double x = (width - source.getWidth() * scale) / 2;
	    double y = (height - source.getHeight() * scale) / 2;
	    AffineTransform at = AffineTransform.getScaleInstance(x, y);
	    at.scale(scale, scale);
	    g2.drawRenderedImage(source, at);
	    g2.dispose();
	    return thumbnNailImage;		
	}
	
	private static BufferedImage normalizeImage(BufferedImage input) {
		Image image = com.twelvemonkeys.image.ImageUtil.grayscale(input);
		input = com.twelvemonkeys.image.ImageUtil.toBuffered(image, BufferedImage.TYPE_BYTE_GRAY);
		ICC_Profile ip = ICC_Profile.getInstance(ColorSpace.CS_GRAY);
		ICC_ColorSpace ics = new ICC_ColorSpace(ip);
		ColorConvertOp cco = new ColorConvertOp(ics, null);
		input = cco.filter(input, input);
		return input;
	}
	
	private static BufferedImage getGrayBufferedImage(InputStream inputStream) throws IOException {
		BufferedImage bufferedImage = null;
		Iterator<ImageReader> iter = ImageIO.getImageReaders(inputStream);
		IOException lastException = null;
        while (iter.hasNext()) {
            ImageReader reader = null;
            try {
                reader = (ImageReader)iter.next();
                ImageReadParam param = reader.getDefaultReadParam();
                reader.setInput(inputStream, true, true);
                Iterator<ImageTypeSpecifier> imageTypes = reader.getImageTypes(0);
                while (imageTypes.hasNext()) {
                    ImageTypeSpecifier imageTypeSpecifier = imageTypes.next();
                    int bufferedImageType = imageTypeSpecifier.getBufferedImageType();
                    if (bufferedImageType == BufferedImage.TYPE_BYTE_GRAY) {
                        param.setDestinationType(imageTypeSpecifier);
                        break;
                    }
                }
                bufferedImage = reader.read(0, param);
                if (null != bufferedImage) break;
            } catch (IOException e) {
                lastException = e;
            } finally {
                if (null != reader) reader.dispose();               
            }
        }
        if (null == bufferedImage) {
            if (null != lastException) {
                throw lastException;
            }
        }		
		return bufferedImage;
	}
	
	private static IIOMetadata getIIOMetadata(
			ImageWriter writer, 
			ImageWriteParam writeParam, 
			boolean isCompression,
			String outputCompression,
			float compressionQuality,
			int dpi,
			BufferedImage input,
			String fileName) throws IIOInvalidTreeException {
		if(isCompression) {
            writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writeParam.setCompressionType(outputCompression);
            writeParam.setCompressionQuality(compressionQuality);
            
            //if(writeParam.canWriteTiles()) {
            //	writeParam.setTilingMode(ImageWriteParam.MODE_DEFAULT);
            //}
		}
		else {
			writeParam.setCompressionMode(ImageWriteParam.MODE_COPY_FROM_METADATA);
		}
		return createMetadata(writer, writeParam, dpi, input, fileName);
	}
	
	private static IIOMetadata getStreamIIOMetadata(
			ImageWriter writer, 
			ImageWriteParam writeParam) throws IIOInvalidTreeException {
		IIOMetadata streamMetadata = writer.getDefaultStreamMetadata(writeParam);
		IIOMetadataNode root = new IIOMetadataNode("com_sun_media_imageio_plugins_tiff_stream_1.0");
		IIOMetadataNode byteOrder = new IIOMetadataNode("ByteOrder");
		byteOrder.setAttribute("value", "LITTLE_ENDIAN");
		root.appendChild(byteOrder);
		streamMetadata .mergeTree("com_sun_media_imageio_plugins_tiff_stream_1.0", root);		
		return streamMetadata;
	}

	private static IIOMetadata createMetadata(ImageWriter writer, ImageWriteParam writerParams, int resolution, BufferedImage input, String fileName) throws IIOInvalidTreeException {
		ImageTypeSpecifier type = null;
		if(writerParams.getCompressionType().toUpperCase().contains("JPEG")) {
			type = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_BYTE_GRAY);
		}
		else {
			type = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_BYTE_BINARY);
		}
		IIOMetadata meta = writer.getDefaultImageMetadata(type, writerParams);
		TIFFDirectory dir = TIFFDirectory.createFromMetadata(meta);
		BaselineTIFFTagSet base = BaselineTIFFTagSet.getInstance();
		TIFFTag tagXRes = base.getTag(BaselineTIFFTagSet.TAG_X_RESOLUTION);
		TIFFTag tagYRes = base.getTag(BaselineTIFFTagSet.TAG_Y_RESOLUTION);
		TIFFField fieldXRes = new TIFFField(tagXRes, TIFFTag.TIFF_RATIONAL, 1, new long[][] { { resolution, 1 } });
		TIFFField fieldYRes = new TIFFField(tagYRes, TIFFTag.TIFF_RATIONAL, 1, new long[][] { { resolution, 1 } });
		TIFFTag tagDocumentName = base.getTag(BaselineTIFFTagSet.TAG_DOCUMENT_NAME);
		if(fileName.length() > 30) {
			fileName = fileName.substring(fileName.length() - 30, fileName.length());
		}
		
		TIFFTag tagNewSubFileType = base.getTag(BaselineTIFFTagSet.TAG_NEW_SUBFILE_TYPE);
		TIFFField fieldNewSubFileType =  new TIFFField(tagNewSubFileType, TIFFTag.TIFF_LONG, 1, new long[] {0l});
		dir.addTIFFField(fieldNewSubFileType);
		

		TIFFField fieldDocumentName =  new TIFFField(tagDocumentName, TIFFTag.TIFF_ASCII, 1, new String[] {fileName});
		dir.addTIFFField(fieldXRes);
		dir.addTIFFField(fieldYRes);
		dir.addTIFFField(new TIFFField(base.getTag(BaselineTIFFTagSet.TAG_RESOLUTION_UNIT), BaselineTIFFTagSet.RESOLUTION_UNIT_INCH));
		dir.addTIFFField(fieldDocumentName);
		
		TIFFTag tagCompression = base.getTag(BaselineTIFFTagSet.TAG_COMPRESSION);
		TIFFField fieldCompression;
		switch(writerParams.getCompressionType()) {
			case "NONE": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_NONE);
					break;
			case "CCITT RLE": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_CCITT_RLE);
					break;
			case "CCITT T.4": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_CCITT_T_4);
					break;
			case "CCITT T.6": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_CCITT_T_6);

					TIFFTag tagT6Options = base.getTag(BaselineTIFFTagSet.TAG_T6_OPTIONS);
					TIFFField fieldT6Options =  new TIFFField(tagT6Options, TIFFTag.TIFF_LONG, 1, new long[] {0l});
					dir.addTIFFField(fieldT6Options);
					
					TIFFTag tagBitsPerSample = base.getTag(BaselineTIFFTagSet.TAG_BITS_PER_SAMPLE);
					TIFFField fieldBitsPerSample =  new TIFFField(tagBitsPerSample, TIFFTag.TIFF_SHORT, 1, new char[] {'\u0001'});
					dir.addTIFFField(fieldBitsPerSample);

					TIFFTag tagSoftware = base.getTag(BaselineTIFFTagSet.TAG_SOFTWARE);
					TIFFField fieldSoftware =  new TIFFField(tagSoftware, TIFFTag.TIFF_ASCII, 1, new String[] {"SKEnt"});
					dir.addTIFFField(fieldSoftware);

					TIFFTag tagDateTime = base.getTag(BaselineTIFFTagSet.TAG_DATE_TIME);
					TIFFField fieldDateTime =  new TIFFField(tagDateTime, TIFFTag.TIFF_ASCII, 1, new String[] {new Date().toString()});
					dir.addTIFFField(fieldDateTime);

					TIFFTag tagFillOrder = base.getTag(BaselineTIFFTagSet.TAG_FILL_ORDER);
					TIFFField fieldFillOrder =  new TIFFField(tagFillOrder, TIFFTag.TIFF_LONG, 1, new long[] {1l});
					dir.addTIFFField(fieldFillOrder);

					TIFFTag tagThreshholding = base.getTag(BaselineTIFFTagSet.TAG_THRESHHOLDING);
					TIFFField fieldThreshholding =  new TIFFField(tagThreshholding, TIFFTag.TIFF_LONG, 1, new long[] {1l});
					dir.addTIFFField(fieldThreshholding);
					
					break;
			case "LZW": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_LZW);
					break;
			case "JPEG": 
				fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_JPEG);

				TIFFTag tagJpegProc = base.getTag(BaselineTIFFTagSet.TAG_JPEG_PROC);
				TIFFField fieldJpegProc =  new TIFFField(tagJpegProc, TIFFTag.TIFF_SHORT, 1, new char[] {'\u0001'});
				dir.addTIFFField(fieldJpegProc);
				
					break;
			case "ZLIB": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_ZLIB);
					break;
			case "PACKBITS": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_PACKBITS);
					break;
			case "DEFLATE": 
					fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_DEFLATE);
					break;
			case "EXIF JPEG": 
				fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_OLD_JPEG);
				break;
			default: 
				fieldCompression =  new TIFFField(tagCompression, TIFFTag.TIFF_SLONG, BaselineTIFFTagSet.COMPRESSION_NONE);
				break;
		}
		dir.addTIFFField(fieldCompression);
		
		TIFFTag tagRowsPerStrip = base.getTag(BaselineTIFFTagSet.TAG_ROWS_PER_STRIP);
		TIFFField fieldRowsPerStrip =  new TIFFField(tagRowsPerStrip, input.getHeight());
		dir.addTIFFField(fieldRowsPerStrip);
		
		return dir.getAsMetadata();
	}
	
	private static void printMeta(IIOMetadata meta) {
		for(String format:meta.getMetadataFormatNames()) {
			Node node = meta.getAsTree(format);
			printNode(node);
		}
	}
	
	private static void printNode(Node node) {
		System.out.println("NodeName:" + node.getNodeName());
		if(!node.hasChildNodes()) {
			System.out.println("Value:" + node.getNodeValue());
		}
		else {
			NodeList list = node.getChildNodes();
			for(int i = 0; i < list.getLength(); i++) {
				printNode(list.item(i));
			}
		}
		if(node.hasAttributes()) {
			NamedNodeMap map = node.getAttributes();
			for(int i = 0; i < map.getLength(); i++) {
				Node attr = map.item(i);
				printNode(attr);
			}
		}
	}
	
	private static BufferedImage setImageColorBitDepth(BufferedImage bufferedImage, int bitRequired) {
		if(bitRequired == 1) {
			return ConvertUtil.convert1(bufferedImage);
		}
		else if(bitRequired == 4) {
			return ConvertUtil.convert4(bufferedImage);
		}
		else if(bitRequired == 8) {
			return ConvertUtil.convert8(bufferedImage);
		}
		else if(bitRequired == 24) {
			return ConvertUtil.convert24(bufferedImage);
		}
		else if(bitRequired == 32) {
			return ConvertUtil.convert32(bufferedImage);
		}
		else {
			return bufferedImage;
		}
	}
	
	private static BufferedImage downScale(int height, int width, BufferedImage bufferedImage) {
		if(bufferedImage.getHeight() > height) {
			double factor = bufferedImage.getHeight() / height;
			int calculatedWidth = (int)(bufferedImage.getWidth() / factor);
			bufferedImage = Scalr.resize(bufferedImage, calculatedWidth, height);
		}
		if(bufferedImage.getWidth() > width) {
			double factor = bufferedImage.getWidth() / width;
			int calculatedHeight = (int)(bufferedImage.getHeight() / factor);
			bufferedImage = Scalr.resize(bufferedImage, width, calculatedHeight);
		}
		return bufferedImage;
	}
	
	
	static class ImageSet {
		private ImageS grayF;
		private ImageS btF;
		private ImageS btB;
		
		ImageSet(ImageS grayF, ImageS btF, ImageS btB) {
			this.grayF = grayF;
			this.btF = btF;
			this.btB = btB;
		}
		
		public ImageS getGrayF() {
			return grayF;
		}
		public void setGrayF(ImageS grayF) {
			this.grayF = grayF;
		}
		public ImageS getBtF() {
			return btF;
		}
		public void setBtF(ImageS btF) {
			this.btF = btF;
		}
		public ImageS getBtB() {
			return btB;
		}
		public void setBtB(ImageS btB) {
			this.btB = btB;
		}
	}
	
	static class ImageS {
		private String fileName;
		private boolean gray;
		private boolean front;
		
		ImageS(String fileName, boolean isGray, boolean front) {
			this.fileName = fileName;
			this.gray = isGray;
			this.front = front;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public boolean isGray() {
			return gray;
		}

		public void setGray(boolean gray) {
			this.gray = gray;
		}

		public boolean isFront() {
			return front;
		}

		public void setFront(boolean front) {
			this.front = front;
		}
	}
	
	public static void split(String pathToImage, String pathToSplit) throws Exception {
		LOGGER.info("Inside the ImageMigrationServiceImpl:: split method");
		File oneTiffFile = new File(pathToImage);
		try (ImageInputStream imageInputStream = ImageIO.createImageInputStream(oneTiffFile)) {
			if (imageInputStream == null || imageInputStream.length() == 0) {
				throw new IOException("No TIFF file available to be split: " + pathToImage);
			}
			Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
			if (iterator == null || !iterator.hasNext()) {
				throw new IOException("Image file format not supported by ImageIO: " + pathToImage);
			}
			// We are just looking for the first reader compatible:
			ImageReader reader = iterator.next();
			iterator = null;
			reader.setInput(imageInputStream);
			int nbPages = reader.getNumImages(true);
			// Create directory if not exist
			if (!Paths.get(pathToSplit).toFile().exists()) {
				pathToSplit = Files.createDirectories(Paths.get(pathToSplit)).toString();
			}
			LOGGER.info("Splitting multi tif file");
			for (int i = 0; i < nbPages; i++) {
				BufferedImage bi = reader.read(i);
				File outputfile = new File(pathToSplit + File.separator + (i + 1) + ".tif");
				ImageIO.write(bi, "tif", outputfile);

			}
			LOGGER.info("Splitting multi tif file completed");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while splitting multi TIFF file--> File Name: ", e);
			throw e;
		}
	}	
}
