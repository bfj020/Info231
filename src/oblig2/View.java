package oblig2;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// To be revised
/**
 * Ein klasse som oppretter eit grafisk brukergrensesnitt som brukes for å lagre kontakter.
 * Grensesnittet inneholder ein meny øverst og tekstfelt for å lagre 
 * variablene fornamn,etternamn, firmanamn,telefonnummer og kommentar.
 * Bruker skriver inn tekst i feltene og trykker "Lagre" knappen for å legge ein kontakt i listen.
 * Etter bruker har lagt til dei kontakter som ønskes, velges "Fil" og "Lagre som" valget i menyen
 * Brukeren får opp eit vindu for å opprette ein ny fil å lagre listen i og skriver inn filnavnet og fitypen csv.
 * Deretter trykker bruker "Save" og filen lagres. Når bruker er ferdig med applikasjonen, kan den lukkes enten ved å velge
 * "Lukk" i menyen eller ved å trykke x i hjørnet.
 *   
 * @author Bjørnar Fjeldstad
 *
 * @param <contentPane>
 */

public class View<contentPane> extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar;
	JMenu menu;
	JMenuItem open ; 
	JMenuItem saveAs;
	JMenuItem close;
	JLabel label1;
	JTextArea searchString;
	JTextArea document;
	JPanel plSearchString;
	JScrollPane plDocument;
	JPanel plSearch;
	JPanel plFrequency;
	JPanel plNext;
	JButton search;
	JButton frequency;
	JButton next;
	File fil;
	FileOutputStream fOut;
	PrintWriter pw;
	JFileChooser fChoose;
	int returnValg;
	Action a;
	String textToView;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Konstruktøren til View som oppretter eit frame objekt frå metoden frame.
	 */
	public View(){
		frame();
	}

	/**
	 * Metoden frame setter opp ny instans av contentpane frå klassen JFrame 
	 * Containter contentpane har ein flowlayout frå venstre mot høgre.
	 * Den tar inn objekter i frå metodene setPanelFornamn, setPanelEtternamn,setPanelFirma,setPanelTlf, setPanelKommentar,
	 * setPanelLagre og setMenu som festes i containeren ved å ta inn variabelen contentpane som argument.
	 * contentPane er satt til å vere synlig og har ein fast størrelse og lokasjon på skjermen som ikkje kan endres.
	 * contentPane er også satt til å lukkes og programmet skal termineres nåt bruker lukker vinduet.
	 * Bakgrunnsfargen er satt til gul.
	 * Det opprettes også ein ny KontaktListe som brukes til å legge input frå brukeren inn 
	 * som objekter i ein ArrayList i klassen Kontaktliste og lagre det. 
	 * @throws IOException
	 */
	public void frame(){
		
		StreamReader reader = new StreamReader();
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setPanelShowFrequency(contentPane);
		setPanelSearchString(contentPane);
		setPanelSearchText(contentPane);
		setPanelNext(contentPane);
		setPanelDocument(contentPane);
		setMenu(contentPane);
		setVisible(true);
		setSize(screenSize.width,screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/**
	 * Metoden setMeny intialize a new menu in the container contentPane
	 * Variabelen menyBar initalize a new JMenuBar and sets title to "Document Reader"
	 * @param contentPane
	 * @param fileR 
	 */

	public void setMenu(Container contentPane){
		
		
		menuBar = new JMenuBar();
		setTitle("Document Reader");
		menu = new JMenu("File");
		open = new JMenuItem("Open");
		saveAs = new JMenuItem("Save as");
		close = new JMenuItem("Close");
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(open);
		open.addActionListener(new Action());
		menu.add(saveAs);
		saveAs.addActionListener(this);
		menu.add(close);
		close.addActionListener(new Action());
	}
	/**
	 * Method setPanelSearchString.
	 * @param contentPane
	 */
	public void setPanelSearchString(Container contentPane){
		
		label1 = new JLabel("Search field");
		label1.setPreferredSize(new Dimension(75,30));
		JPanel plSearchString = new JPanel();
		searchString = new JTextArea("");
		searchString.setPreferredSize(new Dimension(350,25));
		contentPane.add(plSearchString);
		plSearchString.add(label1);
		plSearchString.add(searchString);
		
	}
	/**
	 * Method setPanelDocument 
	 */

	public void setPanelDocument(Container contentPane){
		
		textToView = Action.textToString();
		document = new JTextArea("");
		document.setText(textToView);
		document.setPreferredSize(new Dimension(1000,1000));
		plDocument = new JScrollPane(document);
		plDocument.setPreferredSize(new Dimension(1900,900));
		contentPane.add(plDocument);
	}

	/**
	 * Method setPanelSearchText 
	 * @param contentPane 
	 */
	public void setPanelSearchText(Container contentPane){

		plSearch = new JPanel();
		search = new JButton("Search for phrase");
		search.setPreferredSize(new Dimension(215,50));
		contentPane.add(plSearch);
		plSearch.add(search);
		search.addActionListener(this);
	}
	/**
	 * Method setPanelShowFrequency
	 * @param contentPane
	 */
	public void setPanelShowFrequency(Container contentPane){
		plFrequency = new JPanel();
		frequency = new JButton("Show Frequency");
		frequency.setPreferredSize(new Dimension(215,50));
		contentPane.add(plFrequency);
		plFrequency.add(frequency);
		frequency.addActionListener(this);
	}
	/**
	 * Method setPanelNext
	 * @param contentPane
	 */
	
	public void setPanelNext(Container contentPane){
		plNext = new JPanel();
		next = new JButton("Next phrase");
		next.setPreferredSize(new Dimension(215,50));
		contentPane.add(plNext);
		plNext.add(next);
		next.addActionListener(a);
	}
	/**
	 * Method clearFields resets the textareas in search and documents.
	 * 
	 */
	public void clearFields(){
		search.setText("");
		document.setText("");	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



