package aws.s3;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import reactor.core.publisher.Mono;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.core.async.ResponsePublisher;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.CopyObjectRequest;
import software.amazon.awssdk.services.s3.model.CopyObjectResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.GetObjectTaggingRequest;
import software.amazon.awssdk.services.s3.model.GetObjectTaggingResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public class S3MinIOTest {
	
	public static void main(String...args) {
		S3MinIOTest test = new S3MinIOTest();
		test.getFile();
	}

	
	void createFile() {
		PutObjectRequest request = PutObjectRequest
				.builder()
				.contentType("image/jpeg")
				.bucket("minio-bucket")
				.key("core/62d63ab70789ad38270c06bb")
				.build();
		CompletableFuture<PutObjectResponse> cf =  s3.putObject(request,
				AsyncRequestBody.fromFile(new File("1.jpg")));
		try {
			System.out.println(cf.get().eTag());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void getFile() {
		GetObjectRequest request = GetObjectRequest
										.builder()
										.bucket("minio-bucket")
										.key("/1658826064308")
										.build();
		
		CompletableFuture<GetObjectResponse> cf = s3.getObject(request, Paths.get("/myfile1.txt"));
		
		try {
			System.out.println(cf.get().tagCount());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		CompletableFuture<ResponseBytes<GetObjectResponse>> rpToBytes = s3.getObject(request, AsyncResponseTransformer.toBytes());
		CompletableFuture<ResponsePublisher<GetObjectResponse>> rpToPublisher = s3.getObject(request, AsyncResponseTransformer.toPublisher());
		try {
			rpToPublisher.get().subscribe(buffer -> {
				byte[] data = new byte[buffer.limit()];
				buffer.get(data);
				
				
				
			});
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	void copyFile() {
		CompletableFuture<CopyObjectResponse> cf = s3.copyObject(CopyObjectRequest
				.builder()
				.destinationBucket("minio-bucket")
				.destinationKey("/myfile1.txt")
				.sourceKey("/62df8ed5dd5a4c38cffdf461")
				.sourceBucket("minio-bucket")
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
			.endpointOverride(URI.create("http://localhost:8080"))
			.region(Region.AP_EAST_1)
			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("admin", "admin")))
            .build();
	
}
