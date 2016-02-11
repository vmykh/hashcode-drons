package org.dodiks;

import java.io.IOException;

/**
 * Created by Sutula on 11.02.16
 */
public class Main {

    public static final String pathResources = "/Users/Sutula/IdeaProjects/hashCode/hashcode-drons/src/main/resources";

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(pathResources + "/input_data_set.in");
        parser.perform();

        System.out.println();
        System.out.println(parser);
    }

}
