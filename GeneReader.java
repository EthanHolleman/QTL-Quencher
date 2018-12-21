import java.io.*;
import java.util.ArrayList;

public class GeneReader {
	
	public static ArrayList<String> knownReader(String GeneCollection, String chrInterest) { 
		
		ArrayList<String> chrRead = new ArrayList<String>();
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(new FileReader(GeneCollection));
			while((line = br.readLine()) != null) { //reads all rows matching QTL chr number into arraylist chrRead
				
				if(line.contains(chrInterest + "\t")) {
				chrRead.add(line);
				
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException i) {
			
			i.printStackTrace();
		}
		return chrRead;
		

	}
	
	public static ArrayList<String> contains(ArrayList<String> chrRead, QTL theQTL){
			String line;
			int knownGeneStart;
			int knownGeneEnd;
			
			int QTLStart = theQTL.getStart();
			int QTLEnd = theQTL.getEnd();
			ArrayList<String> QTLGenes = new ArrayList<String>();
			
		for(int i = 0; i<chrRead.size();i++) { //checks if genes in chrRead are contained in the passed in QTL
			line = chrRead.get(i);
			
			
			String[] splitter = line.split("\t");
			knownGeneStart = Integer.parseInt(splitter[3]);
			knownGeneEnd = Integer.parseInt(splitter[4]);
			
			if(knownGeneStart >= QTLStart && knownGeneStart <= QTLEnd) {
				QTLGenes.add(theQTL.getQTLName() + "\t" + line);
			}else if(knownGeneEnd >= QTLStart && knownGeneEnd <= QTLEnd) {
				QTLGenes.add(theQTL.getQTLName() + "\t" + line);
			}else if(knownGeneStart >= QTLStart && knownGeneEnd <= QTLEnd) {
				QTLGenes.add(theQTL.getQTLName() + "\t" + line);
			}
			
			
		}
		return QTLGenes;
		
	}
}
