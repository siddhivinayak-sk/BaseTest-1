package minio;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.Result;
import io.minio.UploadObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.http.Method;
import io.minio.messages.Item;

public class MinioTest {
	
	private static String minioURL = "https://minio-api.dev22r1.sbcp.io";
	private static int port = 443;
	private static String accessKey = "core-4-usecaseE";
	private static String secretKey = "";
	
	public static void main(String...args) {
		System.out.println(SasUrl("my-bucket2", "2022/06/29/testfile.txt"));
		
		upload(new File("C:\\sandeep\\sandbox\\minio\\testfile.txt"), "my-bucket2", "2022/06/29/testfile.txt");
		
		//download(new File("C:\\sandeep\\sandbox\\minio\\testfile-d.txt"), "my-bucket2", "2022/06/29/testfile.txt");
		
		//remove("my-bucket2", "2022/06/29/testfile.txt");
		
		//list("my-bucket2", "2022/06/29/").stream().forEach(System.out::println);
		
		
	}
	
	private static MinioClient minioClient() {
		return MinioClient.builder()
				.endpoint(minioURL, port, false)
				.credentials(accessKey, secretKey)
				.build();
	}
	
	private static boolean bucketExists(MinioClient client, String bucketName) 
			throws InvalidKeyException, ErrorResponseException, InsufficientDataException, 
			InternalException, InvalidResponseException, NoSuchAlgorithmException, 
			ServerException, XmlParserException, IllegalArgumentException, IOException {
		return client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
	}
	
	private static boolean createBucketIfNotExists(MinioClient client, String bucketName) 
			throws InvalidKeyException, ErrorResponseException, InsufficientDataException, 
			InternalException, InvalidResponseException, NoSuchAlgorithmException, 
			ServerException, XmlParserException, IllegalArgumentException, IOException {
		boolean isAvailable = bucketExists(client, bucketName);
		if(!isAvailable) {
			client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
		}
		return !isAvailable;
	}
	
	private static boolean upload(File source, String bucketName, String destPath) {
		try {
			MinioClient client = minioClient();
			createBucketIfNotExists(client, bucketName);
			client.uploadObject(
				     UploadObjectArgs.builder()
				         .bucket(bucketName)
				         .object(destPath)
				         .filename(source.getAbsolutePath())
				         //.contentType("video/mp4")
				         .build());
			return true;
		}
		catch(InvalidKeyException | ErrorResponseException | InsufficientDataException 
				| InternalException | InvalidResponseException | NoSuchAlgorithmException 
				| ServerException | XmlParserException | IllegalArgumentException | IOException ex) {
			System.err.println(ex.getLocalizedMessage());
			return false;
		}
	}

	private static boolean download(File download, String bucketName, String destPath) {
		try {
			MinioClient client = minioClient();
			createBucketIfNotExists(client, bucketName);
			client.downloadObject(DownloadObjectArgs.builder()
					.bucket(bucketName)
					.object(destPath)
					.filename(download.getAbsolutePath())
					.build());
			return true;
		}
		catch(InvalidKeyException | ErrorResponseException | InsufficientDataException 
				| InternalException | InvalidResponseException | NoSuchAlgorithmException 
				| ServerException | XmlParserException | IllegalArgumentException | IOException ex) {
			System.err.println(ex.getLocalizedMessage());
			return false;
		}
	}

	private static boolean remove(String bucketName, String destPath) {
		try {
			MinioClient client = minioClient();
			createBucketIfNotExists(client, bucketName);
			client.removeObject(RemoveObjectArgs.builder()
					.bucket(bucketName)
					.object(destPath)
					.build());
			return true;
		}
		catch(InvalidKeyException | ErrorResponseException | InsufficientDataException 
				| InternalException | InvalidResponseException | NoSuchAlgorithmException 
				| ServerException | XmlParserException | IllegalArgumentException | IOException ex) {
			System.err.println(ex.getLocalizedMessage());
			return false;
		}
	}
	
	private static List<String> list(String bucketName, String prefix) {
		try {
			MinioClient client = minioClient();
			createBucketIfNotExists(client, bucketName);
			Iterable<Result<Item>> it = client.listObjects(ListObjectsArgs.builder()
					.bucket(bucketName)
					.prefix(prefix)
					.build());
			return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
		            it.iterator(),
		            Spliterator.ORDERED
		        ), false)
			.map(e -> {
				try {
					return e.get().objectName();
				} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException
						| InsufficientDataException | InternalException | InvalidResponseException
						| NoSuchAlgorithmException | ServerException | XmlParserException | IOException e1) {
					e1.printStackTrace();
					return "";
				}
			})
			.filter(e -> !e.isEmpty())
			.collect(Collectors.toList());
		}
		catch(InvalidKeyException | ErrorResponseException | InsufficientDataException 
				| InternalException | InvalidResponseException | NoSuchAlgorithmException 
				| ServerException | XmlParserException | IllegalArgumentException | IOException ex) {
			System.err.println(ex.getLocalizedMessage());
			return Arrays.asList();
		}
	}

	private static String SasUrl(String bucketName, String destPath) {
		try {
			MinioClient client = minioClient();
			createBucketIfNotExists(client, bucketName);
			return client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
					.method(Method.GET)
					.bucket(bucketName)
					.object(destPath)
					.expiry(60)
					.build());
		}
		catch(InvalidKeyException | ErrorResponseException | InsufficientDataException 
				| InternalException | InvalidResponseException | NoSuchAlgorithmException 
				| ServerException | XmlParserException | IllegalArgumentException | IOException ex) {
			System.err.println(ex.getLocalizedMessage());
			return "";
		}
	}
}
//Documentation: https://docs.min.io/docs/java-client-quickstart-guide.html
//https://github.com/minio/minio-java/tree/release/examples
