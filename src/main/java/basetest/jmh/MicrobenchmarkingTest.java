package basetest.jmh;

import java.io.IOException;
import java.nio.charset.Charset;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class MicrobenchmarkingTest {

	public static void main(String...args) throws IOException {
		org.openjdk.jmh.Main.main(args);
	}
	
	
	//@Benchmark
	//@BenchmarkMode(Mode.AverageTime)
	//@Fork(value = 1, warmups = 1)
	//@OutputTimeUnit(TimeUnit.SECONDS)
	//@Warmup
	public void test1() {
		String str = "A";
		str += "B";
		str += "C";
		str += "D";
		str += "E";
		str += "F";
		str += "G";
		str += "H";
		str += "I";
		str += "J";
		str += "H";
	}
	
	
	//@Benchmark
	//@BenchmarkMode(Mode.AverageTime)
	//@Fork(value = 1, warmups = 1)
	//@OutputTimeUnit(TimeUnit.SECONDS)
	public void test2() {
		StringBuilder str = new StringBuilder();
		str.append("A");
		str.append("B");
		str.append("C");
		str.append("D");
		str.append("E");
		str.append("F");
		str.append("G");
		str.append("H");
		str.append("I");
		str.append("J");
		str.append("H");
	}
	
	
	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	public void benchMurmur(ExecutionPlan plan) {

	    for (int i = plan.iterations; i > 0; i--) {
	        plan.murmur3.putString(plan.password, Charset.defaultCharset());
	    }

	    plan.murmur3.hash();
	}	
	


}


