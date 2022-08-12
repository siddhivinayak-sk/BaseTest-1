package aws.s3;

import java.io.File;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;

//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicSessionCredentials;
//import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.CopyObjectRequest;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.services.s3.model.PutObjectResult;

//import io.minio.GetObjectResponse;
//import reactor.core.publisher.Mono;
//import software.amazon.awssdk.core.async.AsyncRequestBody;
//import software.amazon.awssdk.services.s3.model.CopyObjectResponse;
//import software.amazon.awssdk.services.s3.model.GetObjectTaggingRequest;
//import software.amazon.awssdk.services.s3.model.GetObjectTaggingResponse;
//import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public class S3MinIOTest {
	
	public static void main(String...args) {
		S3MinIOTest test = new S3MinIOTest();
		//test.copyFile();
		test.createFile2();
	}

	
	
	void createFile2() {
		PutObjectResult result = s3client.putObject("", "sbcp-minio-bucket/core-4/service-file-lifecycle-mgt/62d63ab70789ad38270c06bb", new File("C:\\sandeep\\code\\amigos\\minio-jmeter-proj\\Minio Jmeter\\environments\\testdata\\1.jpg"));
		System.out.println(result.getETag());
	}

	/*
	void createFile() {
		PutObjectRequest request = PutObjectRequest
				.builder()
				.contentType("image/jpeg")
				.bucket("sbcp-minio-bucket")
				.key("core-4/service-file-lifecycle-mgt/62d63ab70789ad38270c06bb")
				.build();
		CompletableFuture<PutObjectResponse> cf =  s3.putObject(request,
				AsyncRequestBody.fromFile(new File("C:\\sandeep\\code\\amigos\\minio-jmeter-proj\\Minio Jmeter\\environments\\testdata\\1.jpg")));
		try {
			System.out.println(cf.get().eTag());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void getFile() {
		CompletableFuture<GetObjectResponse> cf = s3.getObject(GetObjectRequest.builder().bucket("mybucket").key("credentials-1.json").build(), Paths.get("c:/sandeep/testfile.txt"));
		try {
			System.out.println(cf.get().tagCount());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void copyFile() {
		CompletableFuture<CopyObjectResponse> cf = s3.copyObject(CopyObjectRequest
				.builder()
				.destinationBucket("mybucket")
				.destinationKey("credentials-4.json")
				.sourceKey("credentials-1.json")
				.sourceBucket("mybucket")
				.build());
		try {
			System.out.println(cf.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void getTags() {
		List<Boolean> retVal = new ArrayList<>();
		CompletableFuture<GetObjectTaggingResponse> cf = s3.getObjectTagging(GetObjectTaggingRequest.builder().bucket("mybucket").key("credentials-4.json").build());
		try {
			System.out.println(cf.get().tagSet());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		Mono
		.fromFuture(cf)
		.doOnNext(it -> System.out.println("1") )
		.map(it -> it.tagSet())
		.doOnNext(it -> System.out.println("2") )
		.map(tags -> !tags.stream().filter(tag -> tag.key().equals("a") && tag.value().equals("") ).collect(Collectors.toSet()).isEmpty() )
		.doOnNext(it -> System.out.println("3") )
		.doOnSuccess(it -> {System.out.println("Is Available: " + it);})
		.subscribe(it ->  retVal.add(it) )
		;
		System.out.println("Result: " + retVal.get(0));
	}
	
	byte[] readFile(String filename) {
		byte[] data = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			data = new byte[fis.available()];
			fis.read(data);
			fis.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
		return data;
	}
	
	S3AsyncClient s3 = S3AsyncClient
			.builder()
			.endpointOverride(URI.create("http://localhost:9000"))
			.region(Region.AP_EAST_1)
			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("pQv8UoUyqx4Qg6Uj", "qDurUUWLGf9ERcT7NIurDzOt8AuB0soN")))
            .build();
	*/
	
	AmazonS3 s3client = AmazonS3ClientBuilder
			.standard()
			.withCredentials(new AWSStaticCredentialsProvider(new BasicSessionCredentials("ATVMV1FIEGGPSBEIF0H5", "lmLSiXyZDurCBU1lDPvNNWRZqZpFserRhLb8KhNb", "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NLZXkiOiJBVFZNVjFGSUVHR1BTQkVJRjBINSIsImV4cCI6MTY1ODIxNDI3NiwicGFyZW50IjoiY29yZS00Iiwic2Vzc2lvblBvbGljeSI6ImV5SnpkR0YwWlcxbGJuUWlPbHQ3SW1GamRHbHZiaUk2V3lKek16cFFkWFJQWW1wbFkzUWlYU3dpY21WemIzVnlZMlVpT2xzaVlYSnVPbUYzY3pwek16bzZPbk5pWTNBdGJXbHVhVzh0WW5WamEyVjBMMk52Y21VdE5DOXpaWEoyYVdObExXWnBiR1V0YkdsbVpXTjVZMnhsTFcxbmRDODJNbVEyTTJGaU56QTNPRGxoWkRNNE1qY3dZekEyWW1JaVhTd2laV1ptWldOMElqb2lRV3hzYjNjaWZWMHNJblpsY25OcGIyNGlPaUl5TURFeUxURXdMVEUzSW4wPSJ9.WWY-dXwle291oW4hnb4Iyquf6S7eFXoTDmkAt8UC7cSQJMRxi-GYC-x1ye95F7HOLGdS5jHGI7MMtpycIK37uw")))
			.withEndpointConfiguration(new EndpointConfiguration("https://minio-api.dev22r1.sbcp.io", "us-east-1"))
			.build();
}
