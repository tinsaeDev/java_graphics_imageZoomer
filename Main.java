


		
		
		
		// Image Zoomer
		// Author : Tinsae Belay
		
		
				import java.awt.*;
				import java.awt.event.*;
				import java.awt.image.*;
				import javax.imageio.*;
				import javax.swing.*;
				import java.io.*;
		
				public class Main extends Component implements ActionListener {
					
					
					
					JFrame window;
					JFrame controlWindow;
						JTextArea controlTextArea; 
					
					Image img;
					
					int margin=0;
					
					
					
					
					
					int zoomedLeft=0;
					int zoomedTop=0;
					int zoomedRight=0;
					int zoomedBottom=0;
					
					final int imageWidth=480;
					final int imageHeight=640;
					
					
					@Override
					public void actionPerformed(ActionEvent event){
						
						
						
						Graphics2D g = (Graphics2D) getGraphics();
						
						
						paint( g );
						// g.fillRect(0,0,500,500);
						g.drawImage(img,0,0,imageWidth,imageHeight, 0+zoomedLeft,0+zoomedTop,imageWidth-zoomedRight,imageHeight-zoomedBottom    ,null);
						Dimension dd = window.getSize();
						
						
						
					}
					
					
					
					
					public Main(){
						
						try{
							
						img = ImageIO.read( new File("image.jpg") );
							
							}
							
						catch(Exception e){
							
								System.err.println("Image file do not exited !");
							
						}
							
							
							
							
						window = new JFrame("Image Zoomer");
						controlWindow = new JFrame("Controling Window");
							controlTextArea = new JTextArea("This will be used",200,100);
							controlTextArea.addKeyListener( new KeyListener(){
								
								
								@Override
								public void keyPressed(KeyEvent event){
									
									if( event.getKeyCode() == 107 ){
										// +
										System.out.println("Event detected");
										
											 zoomedLeft+=5;
											 zoomedTop+=5;
											
											 zoomedRight+=5;
											 zoomedBottom+=5;
										
										
										window.repaint();
										window.validate();
										
										
										
									}
									
									else if( event.getKeyCode()==109 ){
										// -

											 zoomedLeft-=5;
											 zoomedTop-=5;
											
											 zoomedRight-=5;
											 zoomedBottom-=5;
											
											window.repaint();
											window.validate();
										
										
										
									}
									
								}
								
								
								
								@Override
								public void keyReleased(KeyEvent event){
								System.out.println("Event detected");
											
									
									// 
									
								}
													
								
								@Override
								public void keyTyped(KeyEvent event){
									
									
									// 
									
								}
								
								
							} );
							
						controlWindow.add(controlTextArea);
						controlWindow.setLocation( imageWidth,0 );
						controlWindow.setVisible(true);
						
						window.add(this);
						
						
						window.setSize( imageWidth, imageHeight );
						window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						window.setVisible( true );
						
						
						
					}
					
					
					
					public static void main(String[] args){
						
						
						
						Main m = new Main();
						Timer t = new Timer(100,m);
						t.start();
					}
					
				}