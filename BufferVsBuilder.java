// Class to compare StringBuffer vs StringBuilder execution time
public class BufferVsBuilder {
    public static void main(String[] args) {
        // Sample string to concatenate
        String s = "hello";

        // Measure time for StringBuffer
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();

        for(int i=0;i<1000000;i++) {
            sb.append(s);
        }

        long endTime = System.nanoTime();
        long bufferTime = endTime - startTime;

        // Measure time for StringBuilder
        StringBuilder sb1 = new StringBuilder();
        startTime = System.nanoTime();

        for(int i=0;i<1000000;i++) {
            sb1.append(s);
        }

        endTime = System.nanoTime();
        long builderTime = endTime - startTime;

        // Display the results
        System.out.println("Time taken by StringBuffer: " + bufferTime + " ns");
        System.out.println("Time taken by StringBuilder: " + builderTime + " ns");

        if (bufferTime > builderTime) {
            System.out.println("StringBuilder is faster by " + (bufferTime - builderTime) + " ns");
        } else {
            System.out.println("StringBuffer is faster by " + (builderTime - bufferTime) + " ns");
        }
    }
}
// Sample Output ->
//Time taken by StringBuffer: 18549375 ns
//Time taken by StringBuilder: 9053375 ns
//StringBuilder is faster by 9496000 ns