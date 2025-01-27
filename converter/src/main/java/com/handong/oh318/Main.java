package com.handong.oh318;

public class Main {
    
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Arguments: <Java Path> <Drawio Target File Path> <0 = extract, 1 = generate/code>");
            System.exit(1);
        }

        String javaPath = args[0] ; 
        String drawioPath = args[1] ; 

        System.out.println("Java Path: " + javaPath);
        System.out.println("DrawioPath: " + drawioPath);  

        // Extractor
        if ( args[2].equals("0") ) {
            // "/Users/jinil/Desktop/create" 
            // "/Users/jinil/Desktop/test.drawio"
            Extractor extractor = new Extractor(javaPath, drawioPath); 

            extractor.createDrawio();

        // Coder
        } else if ( args[2].equals("1")) { 
            System.out.println("[Coder]") ; 
            Coder coder = new Coder() ; 

            boolean success = coder.createSourceCodes(javaPath, drawioPath) ; 

            if ( success ) { 
                System.out.println("Create Success") ; 
            } else { 
                System.out.println("Cannot create java source codes") ;
            }
        }
    }
}
