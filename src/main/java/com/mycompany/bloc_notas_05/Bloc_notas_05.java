package com.mycompany.bloc_notas_05;

/**
 *
 * @author juand
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class Bloc_notas_05 extends JFrame  {
 
	private static final String ERROR_MESSAGE = null;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextArea texto;
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				
				
				try {
					
					Bloc_notas_05 frame = new Bloc_notas_05();
					frame.setVisible(true);
				
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		});
		

	}
	String val ="";
	int tamano_fuente= 12;
	boolean Guardado = false;

	/**
	 * Create the frame.
             */
        public Bloc_notas_05(){
		//this.setUndecorated(true);//para quitar la decoracion del frame
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		setAlwaysOnTop(false);//para que no se posisione nunca detras de otra aplicacion
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 453, 424);
		
	
	
		JTextArea textArea = new JTextArea(20, 30);
		textArea.setFont(new Font(Times(), Font.PLAIN, tamano_fuente));
		textArea.setCaretColor(Color.GREEN);//paara cambiar el color del cursor de texto
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(sp);
		JScrollPane scrollPane_1 = new JScrollPane();
		sp.setRowHeaderView(scrollPane_1);
		
		
		//
        
		String nombre  = "";
	  	addWindowListener(new WindowAdapter() {
	        
				@Override
				public void windowClosing(WindowEvent e) {
				
					cerrar(textArea.getText());
				}
			});
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		String times ="Times New Roman";
		JTextArea textArea_1 = new JTextArea(5, 0);
		textArea_1.setFont(new Font(times, Font.BOLD | Font.ITALIC, 14));
		textArea_1.setForeground(Color.GREEN);
		textArea_1.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);//para que las letras al tocar el final del vorde tenga un salto de linea
		textArea_1.setCaretColor(Color.GREEN);//paara cambiar el color del cursor de texto
        
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(Color.BLACK);
		textArea_2.setForeground(Color.GREEN);
		contentPane.add(textArea_2, BorderLayout.WEST);

	
        textArea_1.setText(nombre);
        

	    
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		mnNewMenu.setForeground(Color.GREEN);
		mnNewMenu.setBackground(Color.DARK_GRAY);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir archivo");
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem.setForeground(Color.GREEN);
		mntmNewMenuItem.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			//ventana chose para abrir ficheros
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser Chooser = new JFileChooser();
				int selecion = Chooser.showOpenDialog(Chooser);
				if(selecion == JFileChooser.APPROVE_OPTION) {
					File fichero = Chooser.getSelectedFile();

					try (FileReader fr = new FileReader(fichero)){
						//Scanner scaner = new Scanner(file);
						String cadena = "";
						int valor = fr.read();
						while(valor != -1) {
							//String data = scaner.nextLine();
						    cadena = cadena + (char) valor;
						    valor = fr.read();
						    int contador =0;
						   
						}
						//scaner.close();
					 	textArea.setText(cadena);
					    File archivo;
						archivo=Chooser.getSelectedFile();
					    String a = archivo.getName();  
						textArea_1.setText(a);
						
						
					
						
					}catch (IOException e1){
						e1.printStackTrace();
					}
				}	
				val = textArea.getText();
			}

			
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Guardar como");
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_2.setForeground(Color.GREEN);
		mntmNewMenuItem_2.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
	
		
			public void actionPerformed(ActionEvent e) {
				 
				 textArea_1.setText(guardar(textArea.getText()));//inprime el texto de la variable
			
			}
		});
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Buscar palabra");
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_1.setForeground(Color.GREEN);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setPreferredSize(new Dimension(400, 300));
		        b(textArea.getText());
			  	  
		    }
            });
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Nuevo");
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_3.setForeground(Color.GREEN);
		mntmNewMenuItem_3.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			//ventana chose para abrir ficheros
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");//inprime el texto ingresado
				textArea_1.setText("");
				
			}});
	
	
		
		JMenu mnNewMenu_1 = new JMenu("Contar");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_1.setForeground(Color.GREEN);
		mnNewMenu_1.setBackground(Color.DARK_GRAY);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Caracteres");
		mntmNewMenuItem_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		mntmNewMenuItem_6.setForeground(Color.GREEN);
		mntmNewMenuItem_6.setBackground(Color.DARK_GRAY);
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caracter = textArea.getText();//leer el texto ingresado
				String caracteres = "\n" +" Caracteres: " + caracteres(caracter);
				   textArea_1.setText(caracteres);//inprime el texto de la variable
			}
		});
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Letras");
		mntmNewMenuItem_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_7.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_7.setForeground(Color.GREEN);
		mnNewMenu_1.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letras = textArea.getText();
				int val =0;
				String M = "\n" + " Letras: "+ contar_letras(letras);
				textArea_1.setText(M);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Espacios en blanco");
		mntmNewMenuItem_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_8.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_8.setForeground(Color.GREEN);
		mnNewMenu_1.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String espacios = textArea.getText();
				textArea_1.setText(espacios_en_blanco(espacios));
				
			}
		});
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Todos");
		mntmNewMenuItem_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_9.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_9.setForeground(Color.GREEN);
		mnNewMenu_1.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        int resultado =0;
						String cadena = textArea.getText();//leer el texto ingresado
						textArea_1.setText("");//inprime el texto ingresado
						textArea_1.setText(todos(cadena, resultado));//inprime el texto de la variable	
					}

		});
		
		JMenu mnNewMenu_2 = new JMenu("Acerea de");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		mnNewMenu_2.setForeground(Color.GREEN);
		mnNewMenu_2.setBackground(Color.DARK_GRAY);
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Bloc de notas");
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_4.setForeground(Color.GREEN);
		mntmNewMenuItem_4.setBackground(Color.DARK_GRAY);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText(" Este es un sensillo bloc de notas con diseños que tienen el proposito de disminuir el dolor en los ojos");
			}
		});
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Creador");
		mntmNewMenuItem_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_5.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_5.setForeground(Color.GREEN);
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("ir");
		mntmNewMenuItem_5_1.setForeground(Color.GREEN);
		mntmNewMenuItem_5_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_5_1.setBackground(Color.DARK_GRAY);
		mnNewMenu_2.add(mntmNewMenuItem_5_1);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Fuente");
		mntmNewMenuItem_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		mntmNewMenuItem_10.setForeground(Color.GREEN);
		mntmNewMenuItem_10.setBackground(Color.DARK_GRAY);
		menuBar.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			//ventana chose para abrir ficheros
			public void actionPerformed(ActionEvent e) {
				int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamano que deseas para la fuente"));
	            textArea.setFont(new Font(Times(), Font.PLAIN, valor));

			
  
			}});
			JMenuItem mntmNewMenuItem_11 = new JMenuItem("Espacios en blanco");
		mntmNewMenuItem_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mntmNewMenuItem_11.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_11.setForeground(Color.GREEN);
		mnNewMenu_2.add(mntmNewMenuItem_8);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            textArea_1.setText("juan");
				
			}
		});

		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			//ventana chose para abrir ficheros
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText(" Nombre: Juan Diego Alzate" + "\n" + "juandiegoalzatesuarez169gmail.com");
			}});
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
						
					}

		});

		
		
		
	
    }
    //Metodos y funciones

	

    public void cerrar(String documento) {
        String j = documento;
        System.out.println("juan"+j);
	if(Guardado == true){
	    System.exit(0);
	}else if(Guardado == false){
            int valor = JOptionPane.showConfirmDialog(this, "¿desea guardar los cambios?", "Advertencia", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);	
	    if(valor == JOptionPane.YES_OPTION) {
		guardar(documento);
		System.exit(0);
            }else if(valor == JOptionPane.NO_OPTION) {
	        Guardado = false;
	        System.exit(0);
            }
	}
	  
    }

	public String Times() {
		String Times = "Times New Roman";
		String Arial = "Arial";
		return Times;
		
	}

	public static String guardararchivo(File archivo, String documento) {//metodo para abrirr archivo
		String mensaje=null;
		try {
			FileOutputStream salida;
			salida = new FileOutputStream(archivo);
			byte[] bytxt = documento.getBytes();
			salida.write(bytxt);
			mensaje="Archivo guardado con exito";
		}catch(Exception e){}
		return mensaje;
	}
	public String abrir(boolean contenido,  String mensaje1) {
		String C = "";
		JFileChooser Chooser = new JFileChooser();
		int selecion = Chooser.showOpenDialog(Chooser);
		if (contenido  == true && selecion == JFileChooser.APPROVE_OPTION) {
			   File fichero = Chooser.getSelectedFile();
			   try (FileReader fr = new FileReader(fichero)){
					//Scanner scaner = new Scanner(file);
					String cadena = "";
					int valor = fr.read();
					while(valor != -1) {
						//String data = scaner.nextLine();
					    cadena = cadena + (char) valor;
					    valor = fr.read();
					    int contador =0;
					    if(fr != null) {
					    	System.out.println(contador);
					    	contador++;
					    }
					}
					//scaner.close();
					C = cadena;
				    File archivo;
					archivo=Chooser.getSelectedFile();
					
					String a ="";
					
				    a = archivo.getName();
					mensaje1= " Documento:   " + a + "\n" 
				    + " Documento ubicado en:   "  + archivo ;
				   
				   
				    

				}catch (IOException e1){
					e1.printStackTrace();
				}
			
		    return C;
			
		}else {
		    String s = "error";
			return s;
		}


		
	}
	public String guardar(String documento) {
		String mensaje1 = "";
		JFileChooser seleccionar = new JFileChooser();
		   if(seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
			   File archivo;
			   archivo=seleccionar.getSelectedFile();
			   Guardado = true;
			    String a = archivo.getName();
				   String mensaje = guardararchivo(archivo, documento);
				   mensaje1= " Guardado documento de texto nombrado como:   " + a + ".txt" + "\n" 
				   + " Documento guardado en:   "  + archivo ;
			
		   }
			return mensaje1;
		  
    	}
	                       

	  
	   static String buscar (String in, String out) {
           
			if(in.equals(out)) {
				System.out.println(" encontrado [ "+ out + " ]");
			}else {
				System.out.println(" El caracter no se encontro");
			}
			return  out;
	   }
	
	   public String todos (String in, int out) { 
		       String s = in;
		       int caracteres = s.length();
		       out = caracteres;
		       int letras =0;
		       int contar = 000000;
		       int resultado =0;
		       int espaciosEnBlanco = 0;
		       for (int i = 0; i <  caracteres; i++) {
		            if (s.charAt(i) == ' ') {
		                espaciosEnBlanco ++;
		           }
		            else if(s.charAt(i) != ' ') {
		            	 letras++;
		           }
		       }   
			

		       String c = "\n Letras: " + "[ " + letras + " ]";
			   String d = "\n Espacios en blanco :" + "[ " + espaciosEnBlanco + " ]"; 
			   String total = "\n Total caracteres: [ " + caracteres+ " ]";
			   String salto = "\n";
	           return c + d + total + salto ;    
	   }
	   public int caracteres (String in) {
		   String s = in;
		   int caracteres = s.length();
		   return caracteres;
	   }
	   public int contar_letras (String in) {
		   String s = in;
		   int caracteres = s.length();
		   int letras = 0;
		   for (int i = 0; i <  caracteres; i++) {
	            if(s.charAt(i) != ' ') {
	            	letras++;
	           }
	       }
		  int a = letras;
		   return a;
	   }
	   public int cantidad(int cantidad) {
		   cantidad =0;
		   return cantidad;
	   }
	   public String espacios_en_blanco(String in){
		   String s = in;
		   int caracteres = s.length();
		   int  espacios = 0;
		   for (int i = 0; i <  caracteres; i++) {
	            if (s.charAt(i) == ' ') {
	                espacios ++;
	           }
	       } 
		   String d = "\n Espacios en blanco :" + "[ " + espacios + " ]";  
		   String salto = "\n";
		   return d + salto;
	   }
	   public void contador(String accion) {
		   contador2();
		   mensaje("bas bien");
	   }
	   public void contador2() {
		   int contador =0;
		   for (int i = 0; i  > 0; i++) { 
			   contador++;
	       } 
		   mensaje("bas bien");
	   }
	   static String b(String objeto) {
		        boolean bacio = true;
		        String entrada;
                String salida;
                String mensaje = "";
                String error = "";
                
              while(bacio == true) {
				entrada = JOptionPane.showInputDialog(null,"Ingresa palabra a buscar.");
				if(entrada != null) {
					
					if(entrada.equals("")) {
						error("Por favor ingrese un caracter", "Error");
						bacio = true;
					
					}else{
						bacio = false;
						//leer el texto ingresado textArea.getText();
						if(objeto.equals(entrada)) {
						    mensaje = "encontrado [ "+ entrada + " ]";
						    mensaje(mensaje);
						}else {
							error( "El caracter no se encontro", "Error");
					   }
				      }
				}else{	
				   bacio = false;
		        }
               }
				return mensaje + error;
			}
		   

		static String estilo_letra(String string, int i, int j) {
			// TODO Auto-generated method stub
			return string;
		}
	  
	   static String mensaje (String out) {
			  JOptionPane.showMessageDialog(null, out);
			  return out;
	   }
	   static String ingresar (String in) {
			  JOptionPane.showInputDialog(null, in);
			  return in;
	   }
	   static String confirmar (String in) {
		      JOptionPane.showConfirmDialog(null, in);
		      return in;
	   }
	   static String error (String in1, String in2) {
		    JOptionPane.showMessageDialog(null, in1, in2, JOptionPane.ERROR_MESSAGE);
		  return in1; 
	   }
	   static String precaucion (String in) {
		   JOptionPane.showMessageDialog(null, in, in, JOptionPane.WARNING_MESSAGE);
		  return in; 
	   }
	   static String letras() {
		   String a = "a";
		   return a;
	   }
	   static String a (String comparar) {
		   if (comparar == letras()) {
			   return letras();
		   }
		   return comparar ;
	   }

    void ir(JTextArea area) {
        int line=Integer.parseInt(ingresar("Ingresr renglon a buscar"));
        String []t = area.getText().split("\n");
	    int position=0;
	    for(int index=0;index<t.length;index++){
	    	if(index == line-1)break;
	    	if(t[index].length()!=0)
		            position+=t[index].length();
	    }
	    area.setCaretPosition(position+line-1);
	}
    
    void lineas(JTextArea area){
        String []t = area.getText().split("\n");
	int position=0;
	for(int index=0;index<t.length;index++){
		if(t[index].length()!=0)
		        position+=t[index].length();
	}
	area.setCaretPosition(position-1);
	System.out.println(position);
	}

}
	   
	   
	 

