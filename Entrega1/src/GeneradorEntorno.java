/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */

import javax.swing.*;

public class GeneradorEntorno extends JFrame{
    
    private Laberinto LaberintoVirtual = new Laberinto();
    private JLabel[][] LaberintoGrafico = new JLabel[40][40];
    
    
    public GeneradorEntorno()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        
        //Genera el laberinto grafico a partir del Laberinto virtual
        
        GenerarLaberintoGrafico();
    }
    
    private void GenerarLaberintoGrafico()
    {
        for(int i = 0; i < LaberintoVirtual.DevolverCantidadFilasLaberinto(); i++)
        {
            for(int j = 0; j < LaberintoVirtual.DevolverCantidadColumnasLaberinto(); j++)
            {
                LaberintoGrafico[i][j] = new JLabel();
                add(LaberintoGrafico[i][j]);
            	LaberintoGrafico[i][j].setIcon(new ImageIcon("Graficos/Laberinto/Laberinto GIF/" + LaberintoVirtual.DeolverCodigoImagenMatriz(i, j) + ".gif"));
            }
        }
        for(int i = 0; i < LaberintoVirtual.DevolverCantidadFilasLaberinto(); i++)
        {
            for(int j = 0; j < LaberintoVirtual.DevolverCantidadColumnasLaberinto(); j++)
            {
            	LaberintoGrafico[i][j].setBounds(i*LaberintoVirtual.DevolverLargoImagenes(), j*LaberintoVirtual.DevolverAlturaImagenes(), LaberintoVirtual.DevolverLargoImagenes(), LaberintoVirtual.DevolverAlturaImagenes());
                LaberintoGrafico[i][j].validate();
            }
        }
    }
}