
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.text.html.CSS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernando
 */
public class VTotito extends javax.swing.JFrame {

    int jugador;
    int x;
    int cturno = 0;
    int matriz[][] = new int[3][3];
    int maux[][] = new int[3][3];
    String t, nv;
    int n = 10, mov = 0, aux, aux2;
    int v, fila, columna;
    int cx = 0, co = 0;
    int pg = 0;
    Pila p1 = new Pila();

    /**
     * Creates new form VTotito
     */
    public VTotito() {

        initComponents();
        this.getContentPane().setMaximumSize(new Dimension(1000, 739));
        this.getContentPane().setBackground(Colores.CaribbeanGreen);
        nvx.setOpaque(true);
        nvo.setOpaque(true);
        this.jnuevo.setBackground(Colores.MidnightGreenEagle);
        this.deshacer.setBackground(Colores.MidnightGreenEagle);
        this.reiniciar.setBackground(Colores.MidnightGreenEagle);
        for (int i = 0; i <= 2; i++) {
            for (int k = 0; k <= 2; k++) {
                matriz[i][k] = n;
                maux[i][k] = n;
                n++;
            }
        }
    }

    public int cambiarjugador(int x) {
        if (x == 0) {
            x = 1;
            t = "0";
        } else {
            x = 0;
            t = "X";
        }

        return x;
    }

    public void ganar() {
        if (x == 0) {
            co++;
            nv = String.valueOf(co);
            nvo.setText(nv);
        } else {
            cx++;
            nv = String.valueOf(cx);
            nvx.setText(nv);
        }
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        deshacer.setEnabled(false);
        deshacer.setForeground(Color.LIGHT_GRAY);
    }

    private void empate() {

        if ((mov == 9) && (pg == 0)) {
            JOptionPane.showMessageDialog(rootPane, "Ninguno Ganó");
            deshacer.setEnabled(false);
            deshacer.setForeground(Color.LIGHT_GRAY);
        }
    }

    public void activar() {
        b1.setText("");
        b1.setEnabled(true);
        b2.setText("");
        b2.setEnabled(true);
        b3.setText("");
        b3.setEnabled(true);
        b4.setText("");
        b4.setEnabled(true);
        b5.setText("");
        b5.setEnabled(true);
        b6.setText("");
        b6.setEnabled(true);
        b7.setText("");
        b7.setEnabled(true);
        b8.setText("");
        b8.setEnabled(true);
        b9.setText("");
        b9.setEnabled(true);

    }

    private void Borrar() {
        pg = 0;
        mov = 0;
        n = 10;
        for (int i = 0; i <= 2; i++) {
            for (int k = 0; k <= 2; k++) {
                matriz[i][k] = n;
                maux[i][k] = n;
                n++;
            }
            activar();
            deshacer.setEnabled(true);
            deshacer.setForeground(Color.WHITE);
        }
    }

    //TENTATIVO
    public void des() {

        if (mov > 0) {
            for (int i = 2; i >= 0; i--) {
                for (int k = 2; k >= 0; k--) {
                    maux[i][k] = p1.Cima();
                    p1.retirar();
                }
            }
            mov--;
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY MAS JUGADAS");
        }
    }

    public void apilar() {
        for (int i = 0; i <= 2; i++) {
            for (int k = 0; k <= 2; k++) {
                p1.Apilar(matriz[i][k]);
                n++;
            }
        }

    }

    public void comb1() {
        if ((matriz[0][0] == matriz[0][1]) && (matriz[0][1] == matriz[0][2])) {
            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b1, b2, b3);
            pg = 1;
        }
        if ((matriz[0][0] == matriz[1][1]) && (matriz[1][1] == matriz[2][2])) {
            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b1, b5, b9);
            pg = 1;
        }
        if ((matriz[0][0] == matriz[1][0]) && (matriz[1][0] == matriz[2][0])) {

            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b1, b4, b7);
            pg = 1;
        }
        
    }

    public void comb2() {
        if ((matriz[2][0] == matriz[2][1]) && (matriz[2][1] == matriz[2][2])) {

            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b7, b8, b9);
            pg = 1;
        }
        if ((matriz[0][2] == matriz[1][2]) && (matriz[1][2] == matriz[2][2])) {

            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b3, b6, b9);
            pg = 1;
        }
    }

    public void comb3() {
        if ((matriz[0][1] == matriz[1][1]) && (matriz[1][1] == matriz[2][1])) {
            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b2, b5, b8);
            pg = 1;
        }
        if ((matriz[1][0] == matriz[1][1]) && (matriz[1][1] == matriz[1][2])) {

            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b4, b5, b6);
            pg = 1;
        }
        if ((matriz[2][0] == matriz[1][1]) && (matriz[1][1] == matriz[0][2])) {

            JOptionPane.showMessageDialog(null, "JUGADOR " + turno.getText() + " GANO");
            ganar();
            Colores.resaltar(b7, b5, b3);
            pg = 1;
        }

    }

    public void panel() {
        //RECORRIENDO MATRIZ          
        for (int i = 0; i <= 2; i++) {
            for (int k = 0; k <= 2; k++) {
                //PARA BOTON 1
                if ((i == 0) && (k == 0)) {
                    if (matriz[i][k] == 1) {
                        b1.setText("0");
                        b1.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b1.setText("X");
                        b1.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b1.setText("");
                        b1.setEnabled(true);
                    }
                }

                //PARA BOTON 2
                if ((i == 0) && (k == 1)) {
                    if (matriz[i][k] == 1) {
                        b2.setText("0");
                        b2.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b2.setText("X");
                        b2.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b2.setText("");
                        b2.setEnabled(true);
                    }
                }

                //PARA BOTON 3
                if ((i == 0) && (k == 2)) {
                    if (matriz[i][k] == 1) {
                        b3.setText("0");
                        b3.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b3.setText("X");
                        b3.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b3.setText("");
                        b3.setEnabled(true);
                    }
                }

                //PARA BOTON 4
                if ((i == 1) && (k == 0)) {
                    if (matriz[i][k] == 1) {
                        b4.setText("0");
                        b4.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b4.setText("X");
                        b4.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b4.setText("");
                        b4.setEnabled(true);
                    }
                }

                //PARA BOTON 5
                if ((i == 1) && (k == 1)) {
                    if (matriz[i][k] == 1) {
                        b5.setText("0");
                        b5.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b5.setText("X");
                        b5.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b5.setText("");
                        b5.setEnabled(true);
                    }
                }

                //PARA BOTON 6
                if ((i == 1) && (k == 2)) {
                    if (matriz[i][k] == 1) {
                        b6.setText("0");
                        b6.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b6.setText("X");
                        b6.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b6.setText("");
                        b6.setEnabled(true);
                    }
                }

                //PARA BOTON 7
                if ((i == 2) && (k == 0)) {
                    if (matriz[i][k] == 1) {
                        b7.setText("0");
                        b7.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b7.setText("X");
                        b7.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b7.setText("");
                        b7.setEnabled(true);
                    }
                }

                //PARA BOTON 8
                if ((i == 2) && (k == 1)) {
                    if (matriz[i][k] == 1) {
                        b8.setText("0");
                        b8.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b8.setText("X");
                        b8.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b8.setText("");
                        b8.setEnabled(true);
                    }
                }

                //PARA BOTON 9
                if ((i == 2) && (k == 2)) {
                    if (matriz[i][k] == 1) {
                        b9.setText("0");
                        b9.setEnabled(false);
                    }
                    if (matriz[i][k] == 2) {
                        b9.setText("X");
                        b9.setEnabled(false);
                    }
                    if ((matriz[i][k] != 1) && (matriz[i][k] != 2)) {
                        b9.setText("");
                        b9.setEnabled(true);
                    }
                }

            }
        }
    }

    public void color(javax.swing.JButton b) {
        if (t.equalsIgnoreCase("x")) {
            b.setForeground(Colores.ParadisePink);
            turno.setText(t);
            turno.setForeground(Colores.BlueNCS);
        } else {
            b.setForeground(Colores.BlueNCS);
            turno.setText(t);
            turno.setForeground(Colores.ParadisePink);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        turno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        victoria = new javax.swing.JLabel();
        jnuevo = new javax.swing.JButton();
        vx = new javax.swing.JLabel();
        vo = new javax.swing.JLabel();
        deshacer = new javax.swing.JButton();
        nvx = new javax.swing.JLabel();
        nvo = new javax.swing.JLabel();
        reiniciar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOTITO");
        setBackground(new java.awt.Color(6, 214, 160));
        setForeground(new java.awt.Color(0, 97, 117));
        setLocation(new java.awt.Point(340, 150));
        setMaximumSize(new java.awt.Dimension(1000, 739));
        setMinimumSize(new java.awt.Dimension(700, 439));
        getContentPane().setLayout(null);

        b1.setBackground(new java.awt.Color(255, 209, 102));
        b1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(87, 69, 89, 66);

        b2.setBackground(new java.awt.Color(255, 209, 102));
        b2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(203, 69, 89, 66);

        b3.setBackground(new java.awt.Color(255, 209, 102));
        b3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(318, 69, 89, 66);

        b6.setBackground(new java.awt.Color(255, 209, 102));
        b6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        getContentPane().add(b6);
        b6.setBounds(320, 150, 89, 66);

        b4.setBackground(new java.awt.Color(255, 209, 102));
        b4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(90, 150, 89, 66);

        b5.setBackground(new java.awt.Color(255, 209, 102));
        b5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        getContentPane().add(b5);
        b5.setBounds(200, 150, 89, 66);

        b9.setBackground(new java.awt.Color(255, 209, 102));
        b9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });
        getContentPane().add(b9);
        b9.setBounds(318, 227, 89, 66);

        b7.setBackground(new java.awt.Color(255, 209, 102));
        b7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        getContentPane().add(b7);
        b7.setBounds(87, 227, 89, 66);

        b8.setBackground(new java.awt.Color(255, 209, 102));
        b8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        getContentPane().add(b8);
        b8.setBounds(203, 227, 89, 66);

        turno.setBackground(new java.awt.Color(255, 102, 51));
        turno.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        turno.setForeground(new java.awt.Color(255, 102, 51));
        turno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(turno);
        turno.setBounds(530, 90, 75, 50);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 59, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TURNO DEL JUGADOR");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 54, 190, 30);
        getContentPane().add(victoria);
        victoria.setBounds(510, 311, 0, 50);

        jnuevo.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        jnuevo.setForeground(new java.awt.Color(255, 255, 255));
        jnuevo.setText("Nuevo Juego");
        jnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jnuevo);
        jnuevo.setBounds(105, 330, 140, 30);

        vx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vx.setForeground(new java.awt.Color(7, 59, 76));
        vx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vx.setText("Victorias \"O\"");
        getContentPane().add(vx);
        vx.setBounds(447, 220, 100, 15);

        vo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vo.setForeground(new java.awt.Color(7, 59, 76));
        vo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vo.setText("Victorias \"X\"");
        getContentPane().add(vo);
        vo.setBounds(560, 220, 90, 15);

        deshacer.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        deshacer.setForeground(new java.awt.Color(255, 255, 255));
        deshacer.setText("Deshacer");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });
        getContentPane().add(deshacer);
        deshacer.setBounds(270, 330, 140, 30);

        nvx.setBackground(new java.awt.Color(17, 138, 178));
        nvx.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nvx.setForeground(new java.awt.Color(255, 255, 255));
        nvx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nvx);
        nvx.setBounds(570, 240, 70, 80);

        nvo.setBackground(new java.awt.Color(239, 71, 111));
        nvo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nvo.setForeground(new java.awt.Color(255, 255, 255));
        nvo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nvo);
        nvo.setBounds(470, 240, 70, 80);

        reiniciar.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        reiniciar.setForeground(new java.awt.Color(255, 255, 255));
        reiniciar.setText("Reiniciar Conteo");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(reiniciar);
        reiniciar.setBounds(460, 180, 180, 30);

        jMenu2.setText("Acerca de");

        jMenuItem1.setText("Donar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 0;
            columna = 0;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 0;
            columna = 0;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        color(b1);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 0;
            columna = 1;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 0;
            columna = 1;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        color(b2);
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 0;
            columna = 2;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 0;
            columna = 2;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        color(b3);
    }//GEN-LAST:event_b3ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 1;
            columna = 2;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 1;
            columna = 2;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b6);
    }//GEN-LAST:event_b6ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 1;
            columna = 0;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 1;
            columna = 0;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b4);
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 1;
            columna = 1;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 1;
            columna = 1;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b5);
    }//GEN-LAST:event_b5ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 2;
            columna = 2;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 2;
            columna = 2;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b9);
    }//GEN-LAST:event_b9ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 2;
            columna = 0;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 2;
            columna = 0;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b7);
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        // TODO add your handling code here:
        apilar();
        x = cambiarjugador(cturno);
        if (x == 0) {
            aux2 = 1;
            fila = 2;
            columna = 1;
            matriz[fila][columna] = aux2;
        } else {
            aux2 = 2;
            fila = 2;
            columna = 1;
            matriz[fila][columna] = aux2;
        }
        panel();
        comb1();
        comb2();
        comb3();
        mov++;
        empate();
        cturno = x;
        turno.setText(t);
        color(b8);
    }//GEN-LAST:event_b8ActionPerformed

    private void jnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnuevoActionPerformed
        // TODO add your handling code here:
        Borrar();
        Colores.sinResaltar(b1,b2,b3,b4,b5,b6,b7,b8,b9);
    }//GEN-LAST:event_jnuevoActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        des();
        matriz = maux;
        panel();
    }//GEN-LAST:event_deshacerActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        co = 0;
        cx = 0;
        nvo.setText("");
        nvx.setText("");
    }//GEN-LAST:event_reiniciarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    References.goToURL("https://paypal.me/EAjset?locale.x=es_XC");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VTotito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VTotito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VTotito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VTotito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VTotito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton deshacer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton jnuevo;
    private javax.swing.JLabel nvo;
    private javax.swing.JLabel nvx;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel turno;
    private javax.swing.JLabel victoria;
    private javax.swing.JLabel vo;
    private javax.swing.JLabel vx;
    // End of variables declaration//GEN-END:variables
}
