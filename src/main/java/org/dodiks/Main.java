package org.dodiks;

import org.dodiks.instruction.Instruction;

import java.io.*;
import java.util.List;

/**
 * Created by Sutula on 11.02.16
 */
public class Main {

    public static final String pathResources = "/home/mrgibbs/Desktop/init-wls/hashcode/GoogleDron/src/main/resources";

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(pathResources + "/input_data_set.in");
        parser.perform();

	    SimpleAlgo algo = new SimpleAlgo(parser.getWarehouses(), parser.getOrders().subList(0, parser.getOrders().size() / ), parser.getSettings());

	    List<Instruction> instructions = algo.run();


	    FileWriter fileWriter = new FileWriter(new File(pathResources + "/input_data_set.out"));

	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	    bufferedWriter.write("" + instructions.size() + "\n");
	    int i = 0;
	    for (Instruction instruction : instructions) {
		    i++;
		    bufferedWriter.write(instruction.print() + "\n");
	    }

	    bufferedWriter.close();
	    System.out.println("Iterations: " + i);
    }

}
