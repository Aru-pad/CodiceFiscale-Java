import java.awt.*;
import java.util.Arrays;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class codicefiscale extends JFrame implements ActionListener{
	private JTextField Cognometxt = new JTextField();
	private JLabel Cognomelbl = new JLabel("Cognome");
	private JLabel Nomelbl = new JLabel("Nome");
	private JTextField Nometxt = new JTextField();
	private JLabel Comunelbl = new JLabel("Comune");
	private JLabel spacelbl = new JLabel("");
	private JButton Okbtn = new JButton("Calcola");
	private JButton Cancelbtn = new JButton("Reset");
	private JButton Exitbtn = new JButton("Esci");
	private JLabel Datalbl = new JLabel("Data di nascita");
	Integer[] giorni = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	String[] mesi = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	public String[] anni = {"1900","1901","1902","1903","1904","1905","1906","1907","1908","1909","1910","1911","1912","1913","1914","1915","1916","1917","1918","1919","1920","1921","1922","1923","1924","1925","1926","1927","1928","1929","1930","1931","1932","1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};

	file F=new file();
	Object[] objArray = F.convertVectorToArray();
	public String[] array = Arrays.copyOf(objArray,objArray.length,String[].class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox comune = new JComboBox(array);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox<Integer> giorno = new JComboBox<>(giorni);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox mese = new JComboBox(mesi);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox anno = new JComboBox(anni);
	String[] TipoSesso = {"M","F"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox Sesso = new JComboBox(TipoSesso);
	private JLabel Sessolbl = new JLabel("Sesso");


	public codicefiscale()
	{
		this.setVisible(true);
		
		GestoreFinestra gf = new GestoreFinestra();
		addWindowListener(gf);


		setBounds(370, 200, 635, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		c.setLayout(null);


		Cognometxt.setBounds(79, 17, 134, 28);
		c.add(Cognometxt);

		Cognomelbl.setBounds(6, 23, 61, 16);
		c.add(Cognomelbl);

		Nomelbl.setBounds(225, 23, 61, 16);
		getContentPane().add(Nomelbl);
		
		Nometxt.setBounds(315, 17, 134, 28);
		c.add(Nometxt);
		Nometxt.setColumns(10);

		Comunelbl.setBounds(6, 120, 61, 16);
		c.add(Comunelbl);

		comune.setBounds(79, 115, 134, 28);
		c.add(comune);

		Sessolbl.setBounds(6, 72, 61, 16);
		c.add(Sessolbl);

		Sesso.setBounds(79, 66, 60, 28);
		c.add(Sesso);

		Datalbl.setBounds(225, 72, 85, 16);
		c.add(Datalbl);

		giorno.setBounds(315, 68, 45, 28);
		c.add(giorno);

		mese.setBounds(360, 68, 45, 28);
		c.add(mese);

		anno.setBounds(405, 68, 65, 28);
		c.add(anno);

		spacelbl.setBounds(200, 170, 220, 16);
		getContentPane().add(spacelbl);

		Cancelbtn.setBounds(50, 228, 117, 29);
		c.add(Cancelbtn);
		Cancelbtn.addActionListener(this);

		Okbtn.setBounds(250, 228, 117, 29);
		c.add(Okbtn);
		Okbtn.addActionListener(this);

		Exitbtn.setBounds(450, 228, 117, 29);
		c.add(Exitbtn);
		Exitbtn.addActionListener(this);
	}

	public static void main(String[] args) {
		codicefiscale c = new codicefiscale();
	}

	@Override
	public void actionPerformed(ActionEvent e)throws NumberFormatException, NullPointerException {
		String pulsante = e.getActionCommand();

		if (pulsante.equals("Calcola"))
		{
			String CodFisc = "";
			String CognomeCF = "";
			String NomeCF = "";
			CognomeCF = Cognometxt.getText().toUpperCase();
			NomeCF = Nometxt.getText().toUpperCase();
			int annotemp=anno.getSelectedIndex();
			boolean error=false;
			String mesetemp=mese.getSelectedItem().toString();
			int giornotemp=giorno.getSelectedIndex()+1;		
			if(CognomeCF.equalsIgnoreCase(""))
			{
				error=true;
			}
			if(NomeCF.equalsIgnoreCase(""))
			{
				error=true;
			}
			switch(mesetemp)
			{
			case "2":
				if(giornotemp>29)
				{
					error=true;
				}
				else
				{
					if(giornotemp==29)
					{
						float c=annotemp%4;
						if(c!=0)
						{
							error=true;
						}
					}
				}
				break;
			case "4":
				if(giornotemp>30)
				{
					error=true;
				}
				break;
			case "6":
				if(giornotemp>30)
				{
					error=true;
				}
				break;
			case "9":
				if(giornotemp>30)
				{
					error=true;
				}
				break;
			case "11":
				if(giornotemp>30)
				{
					error=true;
				}
				break;
			}
			if(error)
			{
				CodFisc="Dati non validi!";
				spacelbl.setText("                       "+CodFisc);
			}
			else
			{
				/*calcolo prime 3 lettere */
				int cont = 0;
				/*Se Cognome < 3 lettere*/
				if (CognomeCF.length()<3){
					CodFisc+= CognomeCF;
					while (CodFisc.length()<3) CodFisc+= "X";
					cont=3;
				}
				/*Caso normale*/
				for (int i=0;i<CognomeCF.length();i++) {
					if (cont==3) break;
					if (CognomeCF.charAt(i)!='A' && CognomeCF.charAt(i)!='E' &&
							CognomeCF.charAt(i)!='I' && CognomeCF.charAt(i)!='O' &&
							CognomeCF.charAt(i)!='U' && CognomeCF.charAt(i)!=' ') {
						CodFisc+= Character.toString(CognomeCF.charAt(i));
						cont++;
					}
				}
				/* Se consonanti < 3*/
				while (cont<3) {
					for (int i=0;i<CognomeCF.length();i++) {
						if (cont==3) break;
						if (CognomeCF.charAt(i)=='A' || CognomeCF.charAt(i)=='E' ||
								CognomeCF.charAt(i)=='I' || CognomeCF.charAt(i)=='O' ||
								CognomeCF.charAt(i)=='U' && CognomeCF.charAt(i)!=' ') {
							CodFisc+= Character.toString(CognomeCF.charAt(i));
							cont++;
						}
					}
				}
				//Nome
				cont = 0;
				//Consonanti < 3
				if (NomeCF.length()<3){
					CodFisc+= NomeCF;
					while (CodFisc.length()<6) CodFisc+= "X";
					cont=3;
				}
				String mantieni="";
				String mantieni2="";
				String mantieni3=null;
				//Caso normale
				for (int i=0;i<NomeCF.length();i++) {
					if (cont==4) break;
					if (NomeCF.charAt(i)!='A' && NomeCF.charAt(i)!='E' &&
							NomeCF.charAt(i)!='I' && NomeCF.charAt(i)!='O' &&
							NomeCF.charAt(i)!='U' && NomeCF.charAt(i)!=' ') {
						if(cont!=1)  
						{
							if(cont>=2)
							{
								if(mantieni2!="")
								{
									mantieni3=Character.toString(NomeCF.charAt(i));
								}
								else
								{
									mantieni2=Character.toString(NomeCF.charAt(i));
								}
							}
							else
							{
								CodFisc+= Character.toString(NomeCF.charAt(i));
							}
						}
						else mantieni=Character.toString(NomeCF.charAt(i));
						cont++;
					}
				}
				if(mantieni3==null)
				{
					CodFisc+=mantieni;
					CodFisc+=mantieni2;
				}
				else
				{
					CodFisc+=mantieni2;
					CodFisc+=mantieni3;
				}
				//Vocali < 3
				while (cont<3) {
					for (int i=0;i<NomeCF.length();i++) {
						if (cont==3) break;
						if (NomeCF.charAt(i)=='A' || NomeCF.charAt(i)=='E' ||
								NomeCF.charAt(i)=='I' || NomeCF.charAt(i)=='O' ||
								NomeCF.charAt(i)=='U' && NomeCF.charAt(i)!=' ') {
							CodFisc+= Character.toString(NomeCF.charAt(i));
							cont++;
						}
					}
				}
				/* Anno */
				String anno2 = anno.getSelectedItem().toString();
				CodFisc+=anno2.toString().charAt(2);
				CodFisc+=anno2.toString().charAt(3);
				/*Mese*/
				switch (mesetemp) {
				case "1": {CodFisc+="A";break;}
				case "2": {CodFisc+="B";break;}
				case "3": {CodFisc+="C";break;}
				case "4": {CodFisc+="D";break;}
				case "5": {CodFisc+="E";break;}
				case "6": {CodFisc+="H";break;}
				case "7": {CodFisc+="L";break;}
				case "8": {CodFisc+="M";break;}
				case "9": {CodFisc+="P";break;}
				case "10": {CodFisc+="R";break;}
				case "11": {CodFisc+="S";break;}
				case "12": {CodFisc+="T";break;}
				}
				/*Giorno*/
				int gior=giorno.getSelectedIndex()+1;

				int gio=gior;
				String sesso2=Sesso.getSelectedItem().toString();
				boolean comp=sesso2.equals("F");
				if (comp)
				{
					gio+=40;
					CodFisc+=Integer.toString(gio);
				}
				else {
					if(gio<10) CodFisc+="0";
					CodFisc+=Integer.toString(gio);

				}
				//Comune
				String ComuneNascita=this.comune.getSelectedItem().toString();
				char cod=ComuneNascita.charAt(0);
				char cod2=ComuneNascita.charAt(1);
				char cod3=ComuneNascita.charAt(2);
				char cod4=ComuneNascita.charAt(3);
				CodFisc+=cod;
				CodFisc+=cod2;
				CodFisc+=cod3;
				CodFisc+=cod4;
				/*Carattere di controllo*/
				int sommaPari=0;
				for (int i=1;i<CodFisc.length();i+=2) {
					switch (CodFisc.charAt(i)) {
					case '0': {sommaPari+=0;break;}
					case '1': {sommaPari+=1;break;}
					case '2': {sommaPari+=2;break;}
					case '3': {sommaPari+=3;break;}
					case '4': {sommaPari+=4;break;}
					case '5': {sommaPari+=5;break;}
					case '6': {sommaPari+=6;break;}
					case '7': {sommaPari+=7;break;}
					case '8': {sommaPari+=8;break;}
					case '9': {sommaPari+=9;break;}
					case 'A': {sommaPari+=0;break;}
					case 'B': {sommaPari+=1;break;}
					case 'C': {sommaPari+=2;break;}
					case 'D': {sommaPari+=3;break;}
					case 'E': {sommaPari+=4;break;}
					case 'F': {sommaPari+=5;break;}
					case 'G': {sommaPari+=6;break;}
					case 'H': {sommaPari+=7;break;}
					case 'I': {sommaPari+=8;break;}
					case 'J': {sommaPari+=9;break;}
					case 'K': {sommaPari+=10;break;}
					case 'L': {sommaPari+=11;break;}
					case 'M': {sommaPari+=12;break;}
					case 'N': {sommaPari+=13;break;}
					case 'O': {sommaPari+=14;break;}
					case 'P': {sommaPari+=15;break;}
					case 'Q': {sommaPari+=16;break;}
					case 'R': {sommaPari+=17;break;}
					case 'S': {sommaPari+=18;break;}
					case 'T': {sommaPari+=19;break;}
					case 'U': {sommaPari+=20;break;}
					case 'V': {sommaPari+=21;break;}
					case 'W': {sommaPari+=22;break;}
					case 'X': {sommaPari+=23;break;}
					case 'Y': {sommaPari+=24;break;}
					case 'Z': {sommaPari+=25;break;}
					}
				}
				int sommaDispari=0;
				for (int i=0;i<CodFisc.length();i+=2) {
					char cerca=CodFisc.charAt(i);
					switch (cerca) {
					case '0': {sommaDispari+=1;break;}
					case '1': {sommaDispari+=0;break;}
					case '2': {sommaDispari+=5;break;}
					case '3': {sommaDispari+=7;break;}
					case '4': {sommaDispari+=9;break;}
					case '5': {sommaDispari+=13;break;}
					case '6': {sommaDispari+=15;break;}
					case '7': {sommaDispari+=17;break;}
					case '8': {sommaDispari+=19;break;}
					case '9': {sommaDispari+=21;break;}
					case 'A': {sommaDispari+=1;break;}
					case 'B': {sommaDispari+=0;break;}
					case 'C': {sommaDispari+=5;break;}
					case 'D': {sommaDispari+=7;break;}
					case 'E': {sommaDispari+=9;break;}
					case 'F': {sommaDispari+=13;break;}
					case 'G': {sommaDispari+=15;break;}
					case 'H': {sommaDispari+=17;break;}
					case 'I': {sommaDispari+=19;break;}
					case 'J': {sommaDispari+=21;break;}
					case 'K': {sommaDispari+=2;break;}
					case 'L': {sommaDispari+=4;break;}
					case 'M': {sommaDispari+=18;break;}
					case 'N': {sommaDispari+=20;break;}
					case 'O': {sommaDispari+=11;break;}
					case 'P': {sommaDispari+=3;break;}
					case 'Q': {sommaDispari+=6;break;}
					case 'R': {sommaDispari+=8;break;}
					case 'S': {sommaDispari+=12;break;}
					case 'T': {sommaDispari+=14;break;}
					case 'U': {sommaDispari+=16;break;}
					case 'V': {sommaDispari+=10;break;}
					case 'W': {sommaDispari+=22;break;}
					case 'X': {sommaDispari+=25;break;}
					case 'Y': {sommaDispari+=24;break;}
					case 'Z': {sommaDispari+=23;break;}
					}
				}
				int interoControllo = (sommaPari+sommaDispari)%26;
				String carattereControllo="";
				switch (interoControllo) {
				case 0:{carattereControllo="A";break;}
				case 1:{carattereControllo="B";break;}
				case 2:{carattereControllo="C";break;}
				case 3:{carattereControllo="D";break;}
				case 4:{carattereControllo="E";break;}
				case 5:{carattereControllo="F";break;}
				case 6:{carattereControllo="G";break;}
				case 7:{carattereControllo="H";break;}
				case 8:{carattereControllo="I";break;}
				case 9:{carattereControllo="J";break;}
				case 10:{carattereControllo="K";break;}
				case 11:{carattereControllo="L";break;}
				case 12:{carattereControllo="M";break;}
				case 13:{carattereControllo="N";break;}
				case 14:{carattereControllo="O";break;}
				case 15:{carattereControllo="P";break;}
				case 16:{carattereControllo="Q";break;}
				case 17:{carattereControllo="R";break;}
				case 18:{carattereControllo="S";break;}
				case 19:{carattereControllo="T";break;}
				case 20:{carattereControllo="U";break;}
				case 21:{carattereControllo="V";break;}
				case 22:{carattereControllo="W";break;}
				case 23:{carattereControllo="X";break;}
				case 24:{carattereControllo="Y";break;}
				case 25:{carattereControllo="Z";break;}
				}
				CodFisc+=carattereControllo;
				
				spacelbl.setText("Codice Fiscale: "+CodFisc);
			}
			
		}
		if (pulsante.equals("Reset"))
		{
			Cognometxt.setText("");
			Nometxt.setText("");
			giorno.setSelectedIndex(0);
			mese.setSelectedIndex(0);
			anno.setSelectedIndex(0);
			comune.setSelectedIndex(0);
			Sesso.setSelectedIndex(0);
			spacelbl.setText("");
		}
		if (pulsante.equals("Esci"))
		{
			System.exit(0);

		}
	}

}
