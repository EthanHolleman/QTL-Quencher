import java.io.IOException;
import java.util.ArrayList;

public class QTLMain {

	public static void main(String[] args) throws IOException {
		
		/*This guide assumes any files you are using are formated correctly based on README file
		 * 
		 * Use info
		 * 	to find genes in single QTL create new QTL object
		 * 		QTL objects can be created without a name, but this is not recommended  
		 * 	pass that QTL into the static method .findAQTL along with file path for your known gene selection
		 * 		to print the results to a txt file pass in file path to the findAQTL function
		 * 	
		 * 	to find intersecting genes in a file of QTLs call the static method .findQTLsFromFile
		 * 		this method allows for printing intersecting genes to the console or to a txt file 
		 * 		to print to txt file specify path in method parameters 
		 * 
		 */
		
		String knownGeneFileLocation = "D:\\Download Shite\\Documents\\Research Data\\knownGene.txt";
		String QTLfileLocation = "D:\\Download Shite\\Documents\\Research Data\\qtls.txt";
		String output = "D:\\Download Shite\\Documents\\Research Data\\outgenes.txt";
		
		QTLfinder.findQTLsFromFile(knownGeneFileLocation, QTLfileLocation,output);
		
		
	}
}

