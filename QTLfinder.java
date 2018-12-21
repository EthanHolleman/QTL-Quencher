import java.io.*;
import java.util.ArrayList;

public class QTLfinder {

	//need to add on what QTL the gene was found in (qtl name)
	//takes one QTL object and finds genes from known gene file contained by the QTLs
	
	public static ArrayList<String> findAQTL(QTL theQTL, String GeneCollection)  { //returns QTLS for specific chromosome 
		
		
		
		ArrayList<String> QTLGenes = new ArrayList<String>();
		ArrayList<String> chrRead = new ArrayList<String>();
		
		chrRead = GeneReader.knownReader(GeneCollection, theQTL.getChrNumber());
			
		QTLGenes = GeneReader.contains(chrRead, theQTL);
				
		return QTLGenes;	
			
		}
	
	public void  findAQTL(QTL theQTL, String GeneCollection, String outputLocation)  { //returns QTLS for specific chromosome 
		
		
		
		ArrayList<String> QTLGenes = new ArrayList<String>();
		ArrayList<String> chrRead = new ArrayList<String>();
		
		chrRead = GeneReader.knownReader(GeneCollection, theQTL.getChrNumber());
			
		QTLGenes = GeneReader.contains(chrRead, theQTL);
		
		try {
			
			PrintWriter printer = new PrintWriter(outputLocation);
			for(int i = 0; i<QTLGenes.size();i++) {
				printer.println(QTLGenes.get(i));
			}
			printer.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
			
		}
		
		

	
	
	public static void findQTLsFromFile(String GenesCollection, String QTLlistLocation, String outputLocation) throws IOException {
		
		ArrayList<QTL> QTList = new ArrayList<QTL>();
		ArrayList<String> chrRead = new ArrayList<String>();
		ArrayList<String> checkedGenes = new ArrayList<String>();
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputLocation, true));
		String line;
		
		//read all QTLs from file into array of QTLs objects
	
			BufferedReader br = new BufferedReader(new FileReader(QTLlistLocation));
			while((line = br.readLine()) != null) {
				String[] splitter = line.split("\t");
				QTList.add(new QTL(Integer.parseInt(splitter[1]), Integer.parseInt(splitter[2]), splitter[0], splitter[3]));
				
				
			}
			
			for(int i = 0; i<QTList.size();i++) {
				
				chrRead = GeneReader.knownReader(GenesCollection, QTList.get(i).getChrNumber());
				checkedGenes = GeneReader.contains(chrRead, QTList.get(i));
				for(int j = 0; j<checkedGenes.size(); j++) {
					writer.write("\n" + checkedGenes.get(j));
				}
			}
			
			
		}
	
	//prints QTLs to console instead of to a file location
	public static void findQTLsFromFile(String GenesCollection, String QTLlistLocation) throws IOException {
		
		ArrayList<QTL> QTList = new ArrayList<QTL>();
		ArrayList<String> chrRead = new ArrayList<String>();
		ArrayList<String> checkedGenes = new ArrayList<String>();
		String line;
		
		//read all QTLs from file into array of QTLs objects
	
			BufferedReader br = new BufferedReader(new FileReader(QTLlistLocation));
			while((line = br.readLine()) != null) {
				String[] splitter = line.split("\t");
				QTList.add(new QTL(Integer.parseInt(splitter[1]),Integer.parseInt(splitter[2]),splitter[0]));
				
			}
			
			for(int i = 0; i<QTList.size();i++) {
				
				chrRead = GeneReader.knownReader(GenesCollection, QTList.get(i).getChrNumber());
				checkedGenes = GeneReader.contains(chrRead, QTList.get(i));
				
				for(int j = 0; j<checkedGenes.size(); j++) {
					System.out.println(checkedGenes.get(j));
				}
			}
		
		
	}
}
	
	
	
	
	
	
	

