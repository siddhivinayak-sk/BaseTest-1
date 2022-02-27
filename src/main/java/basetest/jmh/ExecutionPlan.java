package basetest.jmh;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({ "100", "200", "300", "500", "1000" })
    public int iterations;

    public Hasher murmur3;

    public String password = "4v3rys3kur3p455w0rd";

    @Setup(Level.Invocation)
    public void setUp() {
        murmur3 = Hashing.murmur3_128().newHasher();
    }
}
