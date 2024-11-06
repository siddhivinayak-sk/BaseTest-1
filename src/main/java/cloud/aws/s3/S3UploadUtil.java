package cloud.aws.s3;

/**
 * Commented as need to enable dependency in pom.xml
 */

/*
import java.io.ByteArrayInputStream;
import java.io.File;

import org.apache.logging.slf4j.Log4jLogger;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;

public class S3UploadUtil {

	public static String uploadFile(String url, String region, String key, String secret, String token, String remoteFilePath, String localFilePath, Log4jLogger log) {
		logDetails(url, region, key, secret, token, remoteFilePath, localFilePath, log);
		try {
			PutObjectResult result = createClient(url, region, key, secret, token, log).putObject(getTenant(url, log), remoteFilePath, new File(localFilePath));
			if(null != log)
				log.info("File: " + remoteFilePath + "is has been uploaded");
			return result.getETag() + ", Status: 200";
		}
		catch(Exception ex) {
			if(null != log)
				log.error("Error while upload file: " + remoteFilePath, ex);
			ex.printStackTrace();
			return "400";
		}
	}

	public static String uploadInfectedFile(String url, String region, String key, String secret, String token, String remoteFilePath, Log4jLogger log) {
		logDetails(url, region, key, secret, token, remoteFilePath, "", log);
		try {
			String data = "X5O!P%@AP<insert>[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*".replace("<insert>", "");
			ByteArrayInputStream is = new ByteArrayInputStream(data.getBytes());
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentEncoding("UTF-8");
			metadata.setContentType("plain/text");
			metadata.setContentLength(data.getBytes().length);
			
			PutObjectResult result = createClient(url, region, key, secret, token, log)
					.putObject(getTenant(url, log), remoteFilePath, is, metadata);
			if(null != log)
				log.info("File: " + remoteFilePath + "is has been uploaded");
			return result.getETag() + ", Status: 200";
		}
		catch(Exception ex) {
			if(null != log)
				log.error("Error while upload infected file: " + remoteFilePath, ex);
			ex.printStackTrace();
			return "400";
		}
	}
	
	
	public static String downloadFile(String url, String region, String key, String secret, String token, String remoteFilePath, String localFilePath, Log4jLogger log) {
		logDetails(url, region, key, secret, token, remoteFilePath, localFilePath, log);
		try {
			GetObjectRequest request = new GetObjectRequest(getTenant(url, log), remoteFilePath);
			createClient(url, region, key, secret, token, log).getObject(request, new File(localFilePath));
			if(null != log)
				log.info("File Created for key: " + remoteFilePath + " at " + localFilePath);
			return "200";
		} catch(Exception ex) {
			if(null != log)
				log.error("Error while download file: " + remoteFilePath, ex);
			return "400";
		}
	}

	private static void logDetails(String url, String region, String key, String secret, String token, String remoteFilePath, String localFilePath, Log4jLogger log) {
		if(null != log) {
			log.info("S3UploadUtil-URL: " + url);
			log.info("S3UploadUtil-Region: " + region);
			log.info("S3UploadUtil-Key: " + key);
			log.info("S3UploadUtil-Secret: " + secret);
			log.info("S3UploadUtil-Token: " + token);
			log.info("S3UploadUtil-RemotePath: " + remoteFilePath);
			log.info("S3UploadUtil-LocalPath: " + localFilePath);
		}
	}
	
	private static AmazonS3 createClient(String url, String region, String key, String secret, String token, Log4jLogger log) {
		if(null == token) {
			return AmazonS3ClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(key, secret)))
					.withEndpointConfiguration(new EndpointConfiguration(getURLWithoutTenant(url, log), region))
					.build();
		} else {
			return AmazonS3ClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(new BasicSessionCredentials(key, secret, token)))
					.withEndpointConfiguration(new EndpointConfiguration(getURLWithoutTenant(url, log), region))
					.build();
		}
	}
	
	private static String getTenant(String url, Log4jLogger log) {
		try {
			url = url.replace("https://", "").replace("http://", "");
			return url.substring(0, url.indexOf('.'));
		}
		catch(Exception ex) {
			if(null != log) {
				log.error("URL is not correct", ex);
			}
			return " ";
		}
	}

	private static String getURLWithoutTenant(String url, Log4jLogger log) {
		try {
			return url.replace(getTenant(url, log) + ".", "");
		}
		catch(Exception ex) {
			if(null != log) {
				log.error("URL is not correct", ex);
			}
			return url;
		}
	}
}
*/
