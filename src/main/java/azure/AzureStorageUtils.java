//package azure;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.security.InvalidKeyException;
//import java.util.Calendar;
//import java.util.EnumSet;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.TimeZone;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import java.util.stream.StreamSupport;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.microsoft.azure.storage.CloudStorageAccount;
//import com.microsoft.azure.storage.StorageException;
//import com.microsoft.azure.storage.blob.BlobInputStream;
//import com.microsoft.azure.storage.blob.BlobOutputStream;
//import com.microsoft.azure.storage.blob.CloudBlobClient;
//import com.microsoft.azure.storage.blob.CloudBlobContainer;
//import com.microsoft.azure.storage.blob.CloudBlobDirectory;
//import com.microsoft.azure.storage.blob.CloudBlockBlob;
//import com.microsoft.azure.storage.blob.ListBlobItem;
//import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
//import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;
//
//public class AzureStorageUtils {
//
//	private static final Logger LOGGER = Logger.getLogger(AzureStorageUtils.class.getName());
//
//	private static final String LOCAL = "LOCAL";
//	private static final String SEPARATOR = "/";
//
//	private static Function<? super ListBlobItem, ? extends FileDetails> mapToFileDetailsAzure = (tmp) -> {
//		FileDetails retVal = new FileDetails();
//		if (tmp instanceof CloudBlockBlob) {
//			CloudBlockBlob blockBlob = (CloudBlockBlob) tmp;
//			retVal.setFilePath(blockBlob.getName());
//		} else if (tmp instanceof CloudBlobDirectory) {
//			CloudBlobDirectory blobDirectory = (CloudBlobDirectory) tmp;
//			retVal.setFilePath(blobDirectory.getPrefix());
//		} else {
//			retVal.setFilePath(tmp.getStorageUri().toString());
//		}
//		return retVal;
//	};
//
//	private AzureStorageUtils() {
//		throw new IllegalStateException("Utility class");
//	}
//
//	/**
//	 * This method will identify if the configuration set for Local
//	 * 
//	 * @param connectionString
//	 *            Input Connection path
//	 * @return Boolean value
//	 */
//	private static boolean isLocal(String connectionString) {
//		return null != connectionString && connectionString.startsWith(LOCAL);
//	}
//
//	/**
//	 * This method will return the local path from the passed connection string
//	 * 
//	 * @param connectionString
//	 *            Input Connection String
//	 * @return Output local path
//	 */
//	public static String getLocalPath(String connectionString) {
//		return null != connectionString && connectionString.contains(";") ? connectionString.split(";")[1] : null;
//	}
//
//	/**
//	 * This method will return the local base url from the passed connection
//	 * string
//	 * 
//	 * @param connectionString
//	 *            Input Connection String
//	 * @return Output local base url
//	 */
//	public static String getLocalBaseURL(String connectionString) {
//		return null != connectionString && connectionString.contains(";") ? connectionString.split(";")[2] : null;
//	}
//
//	/**
//	 * createCloudBlobClient method is responsible to create CloudBlobClient on
//	 * the basis of azure connectionString.
//	 * 
//	 * @param connectionString
//	 * @return CloudBlobClient
//	 * @throws InvalidKeyException
//	 * @throws URISyntaxException
//	 */
//	private static CloudBlobClient createCloudBlobClient(String connectionString)
//			throws InvalidKeyException, URISyntaxException {
//		LOGGER.info("Inside AzureStorageUtils:: createCloudBlobClient method");
//
//		CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
//		return account.createCloudBlobClient();
//	}
//
//	/**
//	 * getBlobConatiner method is responsible to create CloudBlobContainer.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @return CloudBlobContainer
//	 * @throws InvalidKeyException
//	 * @throws URISyntaxException
//	 * @throws StorageException
//	 */
//	private static CloudBlobContainer getBlobConatiner(String connectionString, String containerName)
//			throws InvalidKeyException, URISyntaxException, StorageException {
//		LOGGER.info("Inside AzureStorageUtils:: getBlobConatiner method");
//
//		CloudBlobClient cloudBlobClient = createCloudBlobClient(connectionString);
//		CloudBlobContainer cloudBlobContainer = cloudBlobClient.getContainerReference(containerName);
//		cloudBlobContainer.createIfNotExists();
//		return cloudBlobContainer;
//	}
//
//	/**
//	 * uploadFile method is responsible to upload file on azure location.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @param data
//	 * @return CloudBlockBlob
//	 * @throws RuntimeException
//	 */
//	public static CloudBlockBlob uploadFile(String connectionString, String containerName, String filePath, byte[] data)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: getBlobConatiner method");
//		try {
//			if (isLocal(connectionString)) {
//				String finalPath = getLocalPath(connectionString) + SEPARATOR + containerName + SEPARATOR + filePath;
//				File tempFile = new File(finalPath);
//				if (!tempFile.getParentFile().exists()) {
//					tempFile.getParentFile().mkdirs();
//				}
//				try (FileOutputStream fos = new FileOutputStream(finalPath)) {
//					fos.write(data);
//					return null;
//				}
//			} else {
//				CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//				CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//				cloudBlockBlob.uploadFromByteArray(data, 0, data.length);
//				return cloudBlockBlob;
//			}
//		} catch (InvalidKeyException | URISyntaxException | StorageException | IOException ex) {
//			LOGGER.error("Exception occurred while upload file on azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * uploadFile method is responsible to upload file on azure location.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return BlobOutputStream
//	 * @throws RuntimeException
//	 */
//	public static BlobOutputStream upload(String connectionString, String containerName, String filePath)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: getBlobConatiner method");
//		try {
//			CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//			CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//			return cloudBlockBlob.openOutputStream();
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while upload file on azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * downloadFile method is responsible to download file from azure location.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return byte[]
//	 * @throws RuntimeException
//	 */
//	public static byte[] downloadFile(String connectionString, String containerName, String filePath)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: downloadFile method");
//		try {
//			if (isLocal(connectionString)) {
//				String finalPath = getLocalPath(connectionString) + SEPARATOR + containerName + SEPARATOR + filePath;
//				return readFileFromFilePath(finalPath);
//			} else {
//				CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//				CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//				cloudBlockBlob.download(outputStream);
//				byte[] byteArray = outputStream.toByteArray();
//				outputStream.close();
//				return byteArray;
//			}
//		} catch (InvalidKeyException | URISyntaxException | StorageException | IOException ex) {
//			LOGGER.error("Exception occurred while download file from azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * downloadFile method is responsible to download file from azure location.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return BlobInputStream
//	 * @throws RuntimeException
//	 */
//	public static BlobInputStream download(String connectionString, String containerName, String filePath)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: downloadFile method");
//		try {
//			CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//			CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//			return cloudBlockBlob.openInputStream();
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while download file from azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * delete method is responsible to delete file from azure location.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return boolean
//	 * @throws RuntimeException
//	 */
//	public static boolean delete(String connectionString, String containerName, String filePath) throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: delete method");
//		try {
//			if (isLocal(connectionString)) {
//				String finalPath = getLocalPath(connectionString) + SEPARATOR + containerName + SEPARATOR + filePath;
//				File localFile = new File(finalPath);
//				boolean retVal = false;
//				if (localFile.exists()) {
//					retVal = localFile.delete();
//				}
//				return retVal;
//			} else {
//				CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//				CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//				return cloudBlockBlob.deleteIfExists();
//			}
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while delete file from azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * sasURL method is responsible to generate SAS url.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return String
//	 * @throws RuntimeException
//	 */
//	public static String sasURL(String connectionString, String containerName, String filePath) throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: sasURL method");
//		try {
//			if (isLocal(connectionString)) {
//				String finalPath = getLocalPath(connectionString) + SEPARATOR + containerName + SEPARATOR + filePath;
//				return getLocalBaseURL(connectionString) + "?filepath=" + finalPath;
//			} else {
//				CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//				CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(filePath);
//				SharedAccessBlobPolicy sasPolicy = new SharedAccessBlobPolicy();
//				GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//				calendar.add(Calendar.MINUTE, 30);
//				sasPolicy.setSharedAccessExpiryTime(calendar.getTime());
//				sasPolicy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.READ, SharedAccessBlobPermissions.WRITE,
//						SharedAccessBlobPermissions.LIST));
//				String sas = cloudBlockBlob.generateSharedAccessSignature(sasPolicy, null);
//				return cloudBlockBlob.getUri() + "?" + sas;
//			}
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while creating sas  url for azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * sasURL method is responsible to generate SAS url for Directory.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return String
//	 * @throws RuntimeException
//	 */
//	public static String sasDirectoryURL(String connectionString, String containerName, String hour)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: sasURL method");
//		try {
//			CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//			SharedAccessBlobPolicy sasPolicy = new SharedAccessBlobPolicy();
//			GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//			calendar.add(Calendar.HOUR, Integer.parseInt(hour));
//			sasPolicy.setSharedAccessExpiryTime(calendar.getTime());
//			sasPolicy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.WRITE));
//			String sas = cloudBlobContainer.generateSharedAccessSignature(sasPolicy, null);
//			return cloudBlobContainer.getUri() + "?" + sas;
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while creating sas  url for azure location! ", ex);
//			throw new AzureException(ex);
//		}
//	}
//
//	/**
//	 * This method takes file path as input, read file and give response in byte
//	 * array
//	 * 
//	 * @param file
//	 *            Input File path
//	 * @return Byte array
//	 * @throws IOException
//	 *             In case of IOException
//	 */
//	public static byte[] readFileFromFilePath(String file) throws IOException {
//		try (FileInputStream fis = new FileInputStream(file);) {
//			byte[] data = new byte[fis.available()];
//			int count = fis.read(data);
//			LOGGER.info("In AzureStorageUtils, Count of bytes of File: " + count);
//			return data;
//		}
//	}
//
//	/*
//	 * public static List filesLst(String connectionString, String
//	 * containerName, String batchDirectory, LocalDate date, BatchProcessDTO
//	 * batchProcessDTO) throws IOException { CloudBlobContainer blobContainer;
//	 * try { blobContainer = getBlobConatiner(connectionString, containerName);
//	 * String filePath = batchDirectory + date.getYear() + "/" +
//	 * date.getMonthValue() + "/" + date.getDayOfMonth() + "/" +
//	 * batchProcessDTO.getId(); CloudBlockBlob cloudBlockBlob =
//	 * blobContainer.getBlockBlobReference(filePath); } catch
//	 * (InvalidKeyException | URISyntaxException | StorageException e) { // TODO
//	 * Auto-generated catch block e.printStackTrace(); }
//	 * 
//	 * List fileLst = new ArrayList<String>(); return fileLst; }
//	 */
//
//	/**
//	 * List all the files/directories from given path.
//	 * 
//	 * @param connectionString
//	 * @param containerName
//	 * @param filePath
//	 * @return List<FileDetails>
//	 * @throws RuntimeException
//	 */
//	public static List<FileDetails> listFiles(String connectionString, String containerName, String filePath)
//			throws AzureException {
//		LOGGER.info("Inside AzureStorageUtils:: getBlobConatiner method");
//		List<FileDetails> fileList = null;
//		try {
//			if (isLocal(connectionString)) {
//				String localContainderPath = getLocalPath(connectionString) + SEPARATOR + containerName;
//				String finalPath = localContainderPath + SEPARATOR + filePath;
//				File tempFile = new File(finalPath);
//				if (tempFile.exists()) {
//					fileList = Stream.of(tempFile.listFiles()).map(tmp -> {
//						FileDetails fileDetails = new FileDetails();
//						fileDetails.setContainer(containerName);
//						fileDetails
//								.setFilePath(tmp.getAbsolutePath().replace("\\", "/").replace(localContainderPath, ""));
//						return fileDetails;
//					}).collect(Collectors.toList());
//				}
//			} else {
//				CloudBlobContainer cloudBlobContainer = getBlobConatiner(connectionString, containerName);
//				Iterable<ListBlobItem> it = cloudBlobContainer.listBlobs(filePath, false);
//				fileList = StreamSupport.stream(it.spliterator(), false).map(mapToFileDetailsAzure)
//						.collect(Collectors.toList());
//				fileList.parallelStream().forEach(tmp -> tmp.setContainer(containerName));
//			}
//		} catch (InvalidKeyException | URISyntaxException | StorageException ex) {
//			LOGGER.error("Exception occurred while upload file on azure location! ", ex);
//			throw new AzureException(ex);
//		}
//		return fileList;
//	}
//
//	static class FileDetails {
//		private String container;
//		private String filePath;
//
//		public FileDetails() {
//			super();
//		}
//
//		public FileDetails(String container, String filePath) {
//			super();
//			this.container = container;
//			this.filePath = filePath;
//		}
//
//		public String getContainer() {
//			return container;
//		}
//
//		public void setContainer(String container) {
//			this.container = container;
//		}
//
//		public String getFilePath() {
//			return filePath;
//		}
//
//		public void setFilePath(String filePath) {
//			this.filePath = filePath;
//		}
//	}
//
//}