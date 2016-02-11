package org.dodiks;

import org.dodiks.instruction.Instruction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sutula on 11.02.16
 */
public class Main {

    public static final String pathResources = "/home/mrgibbs/Desktop/init-wls/hashcode/GoogleDron/src/main/resources";

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(pathResources + "/input_data_set.in");
        parser.perform();

	    SimpleAlgo algo = new SimpleAlgo(parser.getWarehouses(), parser.getOrders(), parser.getSettings());

	    List<Instruction> instructions = algo.run();

	    FileWriter writer = new FileWriter(new File(pathResources + "/input_data_set.out"));

	    writer.write("" + instructions.size() + "\n");
	    for (Instruction instruction : instructions) {
		    writer.write(instruction.print() + "\n");
	    }
    }

}
