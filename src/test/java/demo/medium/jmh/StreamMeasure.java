package demo.medium.jmh;

import demo.medium.java8.Streams;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(5)
@Warmup(iterations = 30)
@Measurement(iterations = 10)
public class StreamMeasure {

    @Benchmark
    public void measureForLoop() {
        Streams.forLoop();
    }

    @Benchmark
    public void measureStreams() {
        Streams.streams();
    }


}
