/**
 * @version 16/07/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Robson Sanchez <BR>
 *
 * Projeto: Freedom <BR>
 * Pacote: org.freedom.componentes <BR>
 * Classe: @(#)StatusBar.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Coment�rios da classe.....
 */

package org.freedom.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import org.freedom.componentes.JLabelPad;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.freedom.bmps.Icone;


/**
 * @author robson
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StatusBar extends JPanel {

	private JPanel pnEst = new JPanel(new BorderLayout());
	private JPanel pnCentro = new JPanel(new BorderLayout());
	private JPanel pnUsuario = new JPanel(new BorderLayout());
	private JPanel pnInfo = new JPanel(new BorderLayout());
	private JPanel pnRelogio = new JPanel(new BorderLayout());
	private JPanel pnDescEst = new JPanel(new BorderLayout());
	private JPanel pnIconEst = new JPanel(new BorderLayout());
	private JPanel pnIconInfo = new JPanel(new BorderLayout());
	private JPanel pnIDUSU = new JPanel(new BorderLayout());
	private JPanel pnDescInfo = new JPanel(new BorderLayout());
	private JPanel pnIconUsuario = new JPanel(new BorderLayout());
	private JLabelPad lEst = new JLabelPad();  
	private JLabelPad lUsuario = new JLabelPad();
	private JLabelPad lInfo = new JLabelPad();
	private JLabelPad lRelogio = new JLabelPad();  
	private int iNumEst = 0;
	private String sDescEst = "";
	private String sIDUsu = "";
	private ImageIcon iconUsuario = Icone.novo("statusbarUsu.gif");
	private ImageIcon iconEst = Icone.novo("statusbarPc.gif");
	private ImageIcon iconRelogio = Icone.novo("statusbarTime.gif");
	private ImageIcon iconInfo = Icone.novo("statusbarInfo.gif");
	
	
	//private Icone.novo("btCalc.gif")

	/**
	 * @param arg0
	 * @param arg1
	 */
	public StatusBar(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		MontaStatusBar();
	}

	/**
	 * @param arg0
	 */
	public StatusBar(LayoutManager arg0) {
		super(arg0);
		MontaStatusBar();
	}

	/**
	 * @param arg0
	 */
	public StatusBar(boolean arg0) {
		super(arg0);
		MontaStatusBar();
	}

	/**
	 * 
	 */
	public StatusBar() {
		super();
		MontaStatusBar();
	}
	private void MontaStatusBar() {
		montaStatus();
		Timer tm = new Timer(1000,
		  new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
			  upRelogio();
			}
		  }
		);
		tm.start();
	}
	
	private void montaStatus() {
		
	  this.setLayout(new BorderLayout());
	  this.setPreferredSize(new Dimension(300, 25));
	  this.setBorder(BorderFactory.createRaisedBevelBorder());

      pnDescEst.add(lEst);
      pnIDUSU.add(lUsuario);
      pnDescInfo.add(lInfo);
      
      pnIconEst.add(new JLabelPad(iconEst),BorderLayout.WEST);
      pnIconUsuario.add(new JLabelPad(iconUsuario),BorderLayout.WEST);
      pnIconInfo.add(new JLabelPad(iconInfo), BorderLayout.WEST);
                 
	  lEst.setPreferredSize(new Dimension(180, 20));
	  lEst.setFont(new Font("Arial", Font.PLAIN, 12));
	  lEst.setForeground( new Color(118, 89, 170));
     
	  lUsuario.setPreferredSize(new Dimension(180, 20));
	  lUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
	  lUsuario.setForeground( new Color(118, 89, 170));

      lInfo.setPreferredSize(new Dimension(180,20));
      lInfo.setFont(new Font("Arial", Font.PLAIN,12));
      lInfo.setForeground(new Color(118, 89, 170));
      
	  pnEst.setPreferredSize(new Dimension(180,23));
	  pnEst.setBorder(BorderFactory.createLoweredBevelBorder());
	  //pnEst.add(lEst, BorderLayout.WEST);
	  
	  pnInfo.setBorder(BorderFactory.createLoweredBevelBorder());
	  
      pnEst.add(pnIconEst,BorderLayout.WEST);
      pnEst.add(pnDescEst,BorderLayout.CENTER);
      
      pnUsuario.add(pnIconUsuario,BorderLayout.WEST);
      pnUsuario.add(pnIDUSU,BorderLayout.CENTER);
      
      pnInfo.add(pnIconInfo,BorderLayout.WEST);
      pnInfo.add(pnDescInfo,BorderLayout.CENTER);
      
      
	  pnUsuario.setBorder(BorderFactory.createLoweredBevelBorder());
	  //pnUsuario.add(lUsuario, BorderLayout.WEST);

      pnCentro.add(pnUsuario, BorderLayout.WEST);
      pnCentro.add(pnInfo, BorderLayout.CENTER);
      
	  this.add(pnEst, BorderLayout.WEST);
	  this.add(pnCentro, BorderLayout.CENTER);
     
	  lRelogio.setPreferredSize(new Dimension(80, 20));
	  lRelogio.setFont(new Font("Arial", Font.PLAIN, 12));
	  lRelogio.setForeground( new Color(118, 89, 170));
	  lRelogio.setHorizontalAlignment(SwingConstants.CENTER);
     
	  pnRelogio.setBorder(BorderFactory.createLoweredBevelBorder());
	  pnRelogio.add(new JLabelPad(iconRelogio),BorderLayout.WEST);
	  pnRelogio.add(lRelogio, BorderLayout.CENTER);
	  this.add(pnRelogio, BorderLayout.EAST);
     
//	  c.add(pnStatus, BorderLayout.SOUTH);
	}
	
	public void upRelogio() {
	  String hora = "";
	  String minuto = "";
	  Calendar cal = Calendar.getInstance();
	  hora = ""+(cal.get(Calendar.HOUR_OF_DAY));
	  minuto = ""+(cal.get(Calendar.MINUTE));
	  minuto = minuto.length() > 1 ? minuto : "0"+minuto;
	  lRelogio.setText(hora+":"+minuto);
	  lRelogio.repaint();
	}
	
	public void setUsuario(String sIDUsu) {
	   this.sIDUsu = sIDUsu.trim();
	   lUsuario.setText(sIDUsu);
	   
	}
	
	public void setNumEst(int iNumEst) {
	   this.iNumEst = iNumEst;
	   ajustaEst(); 		
	}
	
	public void setDescEst(String sDescEst) {
	   this.sDescEst = sDescEst;
	   ajustaEst();	
	}
	
	public int getNumEst() {
	   return iNumEst;	
	}
	
	public String getDescEst() {
	   return sDescEst;
	}
	
	public String getUsuario() {
	   return sIDUsu;	
	}
	
	private void ajustaEst() {
	   lEst.setText((" "+iNumEst+"-"+sDescEst).trim());	
	}
	
	public void setInfo(String sTexto) {
	   if (sTexto==null) 
	      sTexto="";
	   else 
	      sTexto = sTexto.trim();
	   lInfo.setText(sTexto);
	}

}
