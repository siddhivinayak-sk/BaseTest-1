package jwttest;

import java.net.URL;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSObjectJSON;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.PlainObject;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.Ed25519Verifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.mint.ConfigurableJWSMinter;
import com.nimbusds.jose.mint.DefaultJWSMinter;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;

public class JWTTest {
	
	public static void main(String...args) {
		verifyJWTToken();
		
	}

	
	
	
	static void JOSEObjectParsing() {
		try {

			PlainObject plainObject = PlainObject.parse("");
			JWSObject jwsObject = JWSObject.parse("");
			JWEObject jweObject = JWEObject.parse("");
			PlainJWT plainJWT = PlainJWT.parse("");
			SignedJWT signedJWT = SignedJWT.parse("");
			EncryptedJWT encryptedJWT = EncryptedJWT.parse("");
			
			/*
			class Handler implements JOSEObjectHandler<String> {

			    @Override
			    public String onPlainObject(PlainObject plainObject) {
			        return null; // Plain object payload not recognised
			    }

			    @Override
			    public String onJWSObject(JWSObject jwsObject) {
			        // Verify signature
			        boolean success = jwsObject.verify();
			        if (success) {
			            // Return payload as string
			            return jwsObject.getPayload().toString();
			        } else {
			            return null;
			        }
			    }

			    @Override
			    public String onJWEObject(JWEObject jweObject) {
			        jweObject.decrypt(...);
			        return jweObject.getPayload().toString();
			    }
			}

			String content = JOSEObject.parse("", new Handler());	
			*/	
			
			JWT jwt = JWTParser.parse("");
			/*
			class Handler implements JWTHandler<ReadOnlyJWTClaimsSet> {

			    @Override
			    public ReadOnlyJWTClaimsSet onPlainJWT(PlainJWT plainJWT) {
			        return null; // Plain object claims not accepted
			    }

			    @Override
			    public ReadOnlyJWTClaimsSet onSignedJWT(SignedJWT signedJWT) {
			        // Verify signature
			        boolean success = signedJWT.verify(...);
			        if (success) {
			            // Return claims
			            return signedJWT.getClaimsSet();
			        } else {
			            return null;
			        }
			    }

			    @Override
			    public ReadOnlyJWTClaimsSet onEncryptedJWT(EncryptedJWT encryptedJWT) {
			        // Decrypt
			        encryptedJWT.decrypt(...);
			        // Return claims after successful decryption
			        return encryptedJWT.getClaimsSet();
			    }
			}

			// Parse JWTs
			ReadOnlyClaimsSet claims = JWTParser.parse(string, new Handler(...));
			*/
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void verifyJWTToken() {
		try {
			String accessToken =
				    "eyJraWQiOiJDWHVwIiwidHlwIjoiYXQrand0IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJib2IiLCJzY" +
				    "3AiOlsib3BlbmlkIiwiZW1haWwiXSwiY2xtIjpbIiFCZyJdLCJpc3MiOiJodHRwczpcL1wvZGVtby5jM" +
				    "mlkLmNvbVwvYzJpZCIsImV4cCI6MTU3MTMxMjAxOCwiaWF0IjoxNTcxMzExNDE4LCJ1aXAiOnsiZ3Jvd" +
				    "XBzIjpbImFkbWluIiwiYXVkaXQiXX0sImp0aSI6ImJBT1BiNWh5TW80IiwiY2lkIjoiMDAwMTIzIn0.Q" +
				    "hTAdJK8AbdJJhQarjOz_qvAINQeWJCIYSROVaeRpBfaOrTCUy5gWRf8xrpj1DMibdHwQGPdht3chlAC8" +
				    "LGbAorEu0tLLcOwKl4Ql-o30Tdd5QhjNb6PndOY89NbQ1O6cdOZhvV4XB-jUAXi3nDgCw3zvIn2348Va" +
				    "2fOAzxUvRs2OGsEDl5d9cmL3e68YqSh7ss12y9oBDyEyz8Py7dtXgt6Tg67n9WlEBG0r4KloGDBdbCCZ" +
				    "hlEyURkHaE-3nUcjwd-CEVeqWPO0bsLhwto-80j8BtsfD649GnvaMb9YdbdYhTTs-MkRUQpQIZT0s9oK" +
				    "uzKayvZhk0c_0FoSeW7rw";
			
			ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
			jwtProcessor.setJWSTypeVerifier(new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("at+jwt")));
			JWKSource<SecurityContext> keySource = new RemoteJWKSet<>(new URL("https://demo.c2id.com/jwks.json"));
			JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
			JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(expectedJWSAlg, keySource);
			jwtProcessor.setJWSKeySelector(keySelector);
			jwtProcessor.setJWTClaimsSetVerifier(new DefaultJWTClaimsVerifier(
				    new JWTClaimsSet.Builder().issuer("https://demo.c2id.com/c2id").build(),
				    new HashSet<>(Arrays.asList("sub", "iat", "exp", "scp", "cid", "jti"))));			
			SecurityContext ctx = null;
			JWTClaimsSet claimsSet = jwtProcessor.process(accessToken, ctx);
			System.out.println(claimsSet.toJSONObject());
			
			//SecretKey secretKey = null;
			//JWEAlgorithm expectedJWEAlg = JWEAlgorithm.DIR;
			//EncryptionMethod expectedJWEEnc = EncryptionMethod.A128GCM;
			//JWKSource jweKeySource = new ImmutableSecret(secretKey);
			//JWEKeySelector jweKeySelector = new JWEDecryptionKeySelector(expectedJWEAlg, expectedJWEEnc, jweKeySource);
			//jwtProcessor.setJWEKeySelector(jweKeySelector);			
			
			//Detailed Verification: https://connect2id.com/products/nimbus-jose-jwt/examples/validating-jwt-access-tokens
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void mintingJWSwithJWT() {
		try {
			JWK rsaJWK = new RSAKeyGenerator(2048)
				    .keyIDFromThumbprint(true)
				    .keyUse(KeyUse.SIGNATURE)
				    .generate();
			JWK ecJWK = new ECKeyGenerator(Curve.P_256)
				    .keyIDFromThumbprint(true)
				    .keyUse(KeyUse.SIGNATURE)
				    .generate();			
			
			JWKSet jwkSet = new JWKSet(Arrays.asList(rsaJWK, ecJWK));
			JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(jwkSet);
			
			ConfigurableJWSMinter<SecurityContext> minter = new DefaultJWSMinter<>();
			minter.setJWKSource(jwkSource);
			
			JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
				    .type(JOSEObjectType.JWT)
				    .build();
			
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				    .subject("alice")
				    .issuer("https://c2id.com")
				    .issueTime(new Date())
				    .build();
			
			JWSObject jwsObject = minter.mint(header, claimsSet.toPayload(), null);
			System.out.println(jwsObject.serialize());
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void JwtRSAEncryption() {
		try {
			RSAKey rsaJWK = new RSAKeyGenerator(2048).keyID("123").generate();
			KeyPair pair = rsaJWK.toKeyPair();
			
			
			Date now = new Date();
			JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
				    .issuer("https://openid.net")
				    .subject("alice")
				    .audience(Arrays.asList("https://app-one.com", "https://app-two.com"))
				    .expirationTime(new Date(now.getTime() + 1000*60*10)) // expires in 10 minutes
				    .notBeforeTime(now)
				    .issueTime(now)
				    .jwtID(UUID.randomUUID().toString())
				    .build();
			
			JWEHeader header = new JWEHeader(
				    JWEAlgorithm.RSA_OAEP_256,
				    EncryptionMethod.A128GCM
				);
			
			EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);
			
			RSAEncrypter encrypter = new RSAEncrypter(rsaJWK.toPublicJWK());
			
			jwt.encrypt(encrypter);
			
			String jwtString = jwt.serialize();
			System.out.println(jwtString);
			
			EncryptedJWT jwt2 = EncryptedJWT.parse(jwtString);
			RSADecrypter decrypter = new RSADecrypter(rsaJWK.toPrivateKey());
			jwt2.decrypt(decrypter);
			System.out.println(jwt2.serialize());
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void JWEWithSharedKey() {
		try {
			int keyBitLength = EncryptionMethod.A128CBC_HS256.cekBitLength();

			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(keyBitLength);
			SecretKey key = keyGen.generateKey();
			
			JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256);
			Payload payload = new Payload("Hello world!");

			JWEObject jweObject = new JWEObject(header, payload);
			jweObject.encrypt(new DirectEncrypter(key));
			
			String jweString = jweObject.serialize();
			System.out.println(jweString);

			JWEObject jweObject2 = JWEObject.parse(jweString);
			jweObject2.decrypt(new DirectDecrypter(key));
			
			System.out.println(jweObject2.getPayload());
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void JWESignedEncrypted() {
		try {
			RSAKey senderJWK = new RSAKeyGenerator(2048)
				    .keyID("123")
				    .keyUse(KeyUse.SIGNATURE)
				    .generate();
				RSAKey senderPublicJWK = senderJWK.toPublicJWK();
				
			RSAKey recipientJWK = new RSAKeyGenerator(2048)
				    .keyID("456")
				    .keyUse(KeyUse.ENCRYPTION)
				    .generate();
				RSAKey recipientPublicJWK = recipientJWK.toPublicJWK();	
					
			SignedJWT signedJWT = new SignedJWT(
				    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(senderJWK.getKeyID()).build(),
				    new JWTClaimsSet.Builder()
				        .subject("alice")
				        .issueTime(new Date())
				        .issuer("https://c2id.com")
				        .build());					
					
			signedJWT.sign(new RSASSASigner(senderJWK));

			System.out.println("SignedJWT1:" + signedJWT.serialize());
			
			JWEObject jweObject = new JWEObject(
				    new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM)
				        .contentType("JWT") // required to indicate nested JWT
				        .build(),
				    new Payload(signedJWT));
			
			jweObject.encrypt(new RSAEncrypter(recipientPublicJWK));


			String jweString = jweObject.serialize();
			
			System.out.println(jweString);
			
			JWEObject jweObject2 = JWEObject.parse(jweString);
			jweObject2.decrypt(new RSADecrypter(recipientJWK));
			SignedJWT signedJWT2 = jweObject2.getPayload().toSignedJWT();

			System.out.println("SignedJWT2:" + signedJWT2.serialize());
			
			boolean isValid = signedJWT2.verify(new RSASSAVerifier(senderPublicJWK));
			System.out.println(isValid);
			
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void JWEWithRSAnHS256withCEK() {
		try {
			JWEAlgorithm alg = JWEAlgorithm.RSA_OAEP_256;
			EncryptionMethod enc = EncryptionMethod.A128CBC_HS256;
			
			//Encryption of JWE
			KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
			rsaGen.initialize(2048);
			KeyPair rsaKeyPair = rsaGen.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey)rsaKeyPair.getPublic();
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)rsaKeyPair.getPrivate();
			
			//Content Encryption Key (CEK) 
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(enc.cekBitLength());
			SecretKey cek = keyGenerator.generateKey();	
			
			JWEObject jwe = new JWEObject(
				    new JWEHeader(alg, enc),
				    new Payload("Hello, world!"));
				jwe.encrypt(new RSAEncrypter(rsaPublicKey, cek));
			String jweString = jwe.serialize();			
			System.out.println("JWE: " + jweString);
			
			JWEObject jwe2 = JWEObject.parse(jweString);
			jwe2.decrypt(new RSADecrypter(rsaPrivateKey));
			
			System.out.println("JWE Decrypt with RSA:    " + jwe2.serialize());
			System.out.println(jwe2.getPayload());
			
			JWEObject jwe3 = JWEObject.parse(jweString);
			jwe3.decrypt(new DirectDecrypter(cek, true));			
			
			System.out.println("JWE Decrypt with Direct: " + jwe3.serialize());
			System.out.println(jwe2.getPayload());
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void HMACJwtToken() {
		try {
			SecureRandom random = new SecureRandom();
			byte[] sharedSecret = new byte[32];
			random.nextBytes(sharedSecret);
			
			JWSSigner signer = new MACSigner(sharedSecret);
			
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				    .subject("alice")
				    .issuer("https://c2id.com")
				    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
				    .build();
			
			SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

			
			signedJWT.sign(signer);
			
			String s = signedJWT.serialize();
			
			System.out.println(s);
			
			SignedJWT signedJWT2 = SignedJWT.parse(s);

			JWSVerifier verifier = new MACVerifier(sharedSecret);

			boolean isValid = signedJWT2.verify(verifier);
			System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void RSAJwtToken() {
		try {
			RSAKey rsaJWK = new RSAKeyGenerator(2048).keyID("123").generate();
			RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
			JWSSigner signer = new RSASSASigner(rsaJWK);
			
			KeyPair pair = rsaJWK.toKeyPair();
			System.out.println("PublicKey:" + Base64.getEncoder().encodeToString(pair.getPublic().getEncoded()));
			System.out.println("PrivateKey:" + Base64.getEncoder().encodeToString(pair.getPrivate().getEncoded()));

			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				    .subject("alice")
				    .issuer("https://c2id.com")
				    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
				    .build();

			SignedJWT signedJWT = new SignedJWT(
				   new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
				    claimsSet);

			signedJWT.sign(signer);

			String s = signedJWT.serialize();
			System.out.println(s);

			signedJWT = SignedJWT.parse(s);

			JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);
			boolean isValid =signedJWT.verify(verifier);
			System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void ECJwtToken() {
		try {
			ECKey ecJWK = new ECKeyGenerator(Curve.P_256)
				    .keyID("123")
				    .generate();
				ECKey ecPublicJWK = ecJWK.toPublicJWK();

				JWSSigner signer = new ECDSASigner(ecJWK);

				JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				    .subject("alice")
				    .issuer("https://c2id.com")
				    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
				    .build();

				SignedJWT signedJWT = new SignedJWT(
				    new JWSHeader.Builder(JWSAlgorithm.ES256).keyID(ecJWK.getKeyID()).build(),
				    claimsSet);

				signedJWT.sign(signer);

				String s = signedJWT.serialize();
				System.out.println(s);

				signedJWT = SignedJWT.parse(s);

				JWSVerifier verifier = new ECDSAVerifier(ecPublicJWK);
				boolean isValid = signedJWT.verify(verifier);
				System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	static void ESJwtToken() {
		try {
			ECKey ecJWK = new ECKeyGenerator(Curve.SECP256K1).keyUse(KeyUse.SIGNATURE).keyID("123").generate();

			ECKey ecPublicJWK = ecJWK.toPublicJWK();
			
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				    .subject("alice")
				    .build();

				SignedJWT jwt = new SignedJWT(
				    new JWSHeader.Builder(JWSAlgorithm.ES256K)
				        .keyID(ecJWK.getKeyID())
				        .build(),
				    claimsSet);

				jwt.sign(new ECDSASigner(ecJWK));

				String s = jwt.serialize();
				System.out.println(s);
				
				
				SignedJWT jwt2 = SignedJWT.parse(s);
				
				boolean isValid = jwt2.verify(new ECDSAVerifier(ecPublicJWK));
				System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
		
	static void HMACJwsToken() {
		try {
			byte[] sharedKey = new byte[32];
			new SecureRandom().nextBytes(sharedKey);

			JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload("Hello, world!"));
			jwsObject.sign(new MACSigner(sharedKey));
			String token = jwsObject.serialize();
			
			System.out.println(token);
			
			JWSObject jwsObject2 = JWSObject.parse(token);
			
			JWSVerifier verifier = new MACVerifier(sharedKey);
			
			boolean isValid = jwsObject2.verify(verifier);
			System.out.println(isValid);
			System.out.println(jwsObject2.getPayload());
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void RSAJwsToken() {
		try {

			RSAKey rsaJWK = new RSAKeyGenerator(2048).keyID("123").generate();
			RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
			
			JWSSigner signer = new RSASSASigner(rsaJWK);
			
			JWSObject jwsObject = new JWSObject(
				    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
				    new Payload("In RSA we trust!"));
			
			jwsObject.sign(signer);
			
			String s = jwsObject.serialize();
			System.out.println(s);

			jwsObject = JWSObject.parse(s);

			JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);		
			
			boolean isValid = jwsObject.verify(verifier);
			
			System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void ECJwsToken() {
		try {
			ECKey ecJWK = new ECKeyGenerator(Curve.P_256)
				    .keyID("thisisakeyid")
				    .generate();
				ECKey ecPublicJWK = ecJWK.toPublicJWK();

				JWSSigner signer = new ECDSASigner(ecJWK);

				JWSObject jwsObject = new JWSObject(
				    new JWSHeader.Builder(JWSAlgorithm.ES256).keyID(ecJWK.getKeyID()).build(),
				    new Payload("Elliptic cure"));

				jwsObject.sign(signer);

				String s = jwsObject.serialize();
				System.out.println(s);

				JWSVerifier verifier = new ECDSAVerifier(ecPublicJWK);

				boolean isValid = jwsObject.verify(verifier);
				System.out.println(isValid);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void EDJwsToken() {
		try {
			OctetKeyPair jwk = new OctetKeyPairGenerator(Curve.Ed25519)
				    .keyID("123")
				    .generate();
				OctetKeyPair publicJWK = jwk.toPublicJWK();

				JWSSigner signer = new Ed25519Signer(jwk);

				JWSObject jwsObject = null;
				//jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.Ed25519).keyID(jwk.getKeyID()).build(), new Payload("We are having a crypto party!"));

				jwsObject.sign(signer);

				String s = jwsObject.serialize();
				System.out.println(s);

				JWSVerifier verifier = new Ed25519Verifier(publicJWK);

				boolean isValid = jwsObject.verify(verifier);			
		}
		catch(Exception ex) {ex.printStackTrace();}
	}

	static void MultiSignJwsToken() {
		try {
			RSAKey rsaJWK = new RSAKeyGenerator(2048)
				    .algorithm(JWSAlgorithm.RS256)
				    .keyUse(KeyUse.SIGNATURE)
				    .keyID("1")
				    .generate();
			
			ECKey ecJWK = new ECKeyGenerator(Curve.P_256)
				    .algorithm(JWSAlgorithm.ES256)
				    .keyUse(KeyUse.SIGNATURE)
				    .keyID("2")
				    .generate();
			
			Payload payload = new Payload("Hello, world!");
			
			
			JWSObjectJSON jwsObjectJSON = new JWSObjectJSON(payload);
			
			
			jwsObjectJSON.sign(
				    new JWSHeader.Builder((JWSAlgorithm) rsaJWK.getAlgorithm())
				        .keyID(rsaJWK.getKeyID())
				        .build(),
				    new RSASSASigner(rsaJWK)
				);

			jwsObjectJSON.sign(
				    new JWSHeader.Builder((JWSAlgorithm) ecJWK.getAlgorithm())
				        .keyID(ecJWK.getKeyID())
				        .build(),
				    new ECDSASigner(ecJWK)
				);
			
			String json = jwsObjectJSON.serializeGeneral();
			System.out.println(json);
			
			RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
			ECKey ecPublicJWK = ecJWK.toPublicJWK();
			
			JWSObjectJSON jwsObjectJSON2 = JWSObjectJSON.parse(json);
			for (JWSObjectJSON.Signature sig: jwsObjectJSON2.getSignatures()) {

			    // The JWS kid header parameter is used to identify the signing key

			    if (rsaPublicJWK.getKeyID().equals(sig.getHeader().getKeyID())) {
			        if (! sig.verify(new RSASSAVerifier(rsaPublicJWK))) {
			            System.out.println("Invalid RSA signature for key " + rsaPublicJWK.getKeyID());
			        }
			    }

			    if (ecPublicJWK.getKeyID().equals(sig.getHeader().getKeyID())) {
			        if (! sig.verify(new ECDSAVerifier(ecPublicJWK))) {
			            System.out.println("Invalid EC signature for key " + ecJWK.getKeyID());
			        }
			    }
			}

			if (JWSObjectJSON.State.VERIFIED.equals(jwsObjectJSON2.getState())) {
			    System.out.println("JWS JSON verified");
			} else {
			    System.out.println("JWS JSON invalid");
			}
			
			
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
}


//https://connect2id.com/products/nimbus-jose-jwt/examples/jws-with-rsa-signature