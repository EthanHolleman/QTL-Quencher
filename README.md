# QTL-Quencher
Java program designed to find genes that intersect specified QTLs  

Effectively, this program finds genes located in a specific range and then labels any 
found genes with an ID corresponding to the range they were in

This allows a user to create QTLs with a chromosome number, base pair range, and name and 
then search through a known gene data file to identify genes that intersect the QTL
QTLs can either be provided individually or as a collection in a tab delaminated txt file

Format for QTL file

chromosome number start position end position  name

Format for known 
Gene ID chromosome number direction (+,-)  start position  end position  ...

More information may be provided in any given row, but these first four rows must exist in this order

An example known gene file and QTL file have been included in this project for reference

Future Updates

  Ability to specify the type of intersection, such as returning only genes completely contained by QTL
  Currently program returns genes that have at least one base pair intersection at any location in QTL
  
  Report file that will contain info on how many genes where matched to each QTL, QTL with most matches, and other 
  similar statistics
  
  More flexibilty in file formating overall
