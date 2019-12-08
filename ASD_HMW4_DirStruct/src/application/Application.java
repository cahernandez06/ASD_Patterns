package application;

import model.Directory;
import model.Drive;
import model.File;
import model.Link;

public class Application {
	public static void main(String[] args) {
		Drive cdrive = new Drive("C");
		Directory appdir = new Directory("applications");
		Directory datadir = new Directory("my data");
		Directory coursedir = new Directory("cs525");
		File excelfile = new File("msexcel.exe", 2353256);
		File wordfile = new File("msword.exe", 3363858);
		File studentsfile = new File("students.doc", 34252);
		Link shortCutMS = new Link("winword","c:/applications/msword.exe");

		cdrive.addNode(appdir);
		cdrive.addNode(datadir);
		
		datadir.addNode(coursedir);
		
		appdir.addNode(excelfile);
		appdir.addNode(wordfile);
		
		coursedir.addNode(studentsfile);
		coursedir.addNode(shortCutMS);
		
		cdrive.print();
	}
}