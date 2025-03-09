import java.util.ArrayList;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_IP = new javax.swing.JTextField();
        txt_SubnetMask = new javax.swing.JTextField();
        txt_TotalSubnets = new javax.swing.JTextField();
        btn_Calculate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Display = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_TotalSubnets.setText("4");

        btn_Calculate.setText("Calculate");
        btn_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CalculateActionPerformed(evt);
            }
        });

        txt_Display.setColumns(20);
        txt_Display.setRows(5);
        jScrollPane1.setViewportView(txt_Display);

        jLabel1.setText("Ip Address:");

        jLabel2.setText("Subnet Mask:");

        jLabel3.setText("How many networks you want to create:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel4.setText("Subnet Calculator for a Network");

        btn_Exit.setText("Exit");
        btn_Exit.setActionCommand("btn_Exit");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Calculate)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Exit))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(txt_SubnetMask, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TotalSubnets, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_SubnetMask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_TotalSubnets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Calculate)
                    .addComponent(btn_Exit))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalculateActionPerformed
        calculateSubnets();
    }//GEN-LAST:event_btn_CalculateActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_ExitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
    
    private void calculateSubnets(){
        txt_Display.setText("");
        
        if(txt_IP.getText().equals("") || txt_SubnetMask.getText().equals("") || txt_TotalSubnets.getText().equals("")){
            txt_Display.setText("The values cannot be empty.");
            return;
        }
        
        try{
            String ip = txt_IP.getText();
            String mask = txt_SubnetMask.getText();
            int subnetCount = Integer.parseInt(txt_TotalSubnets.getText());
            
            if(!checkRange(ip) || !checkRange(mask)){
                txt_Display.setText("Make sure that your entered values are suitable.");
                return;
            }
            
            int requiredBits = (int)Math.ceil(Math.log(Integer.parseInt(txt_TotalSubnets.getText())) / Math.log(2));
        
            int ipInt = toInt(ip);
            int maskInt = toInt(mask);
            
            int zerosInMask = 32 - Integer.bitCount(maskInt);
        
            int newSubnetMask = maskInt >> requiredBits;
            
            if(zerosInMask - 1 <= requiredBits){
                txt_Display.setText("Invalid subnet count for the network.");
                return;
            }
            int interval = ~newSubnetMask + 1;
            
            ArrayList<IpAddress> ipAddresses = new ArrayList<>();
            for(int i = 0; i < subnetCount; i++){
                ipAddresses.add(new IpAddress(ipInt, newSubnetMask));
                ipInt += interval;
            }

            for(int i = 0; i < ipAddresses.size(); i++){
                txt_Display.setText(txt_Display.getText() + ("Subnet: " + (i + 1) + " - " +
                 "Ip: " + toIp(ipAddresses.get(i).getIpAddress()) + " | " +
                 "Broadcast ip: " + toIp(ipAddresses.get(i).getBroadcastAddress()) + " | " +
                 "Subnet Mask: " + toIp(ipAddresses.get(i).getSubnetMask()) + " | " +
                 "Host Count: " + ipAddresses.get(i).getHostCount() + "\n"));

            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            txt_Display.setText("The values should be complete");
        }
        catch(NumberFormatException e){
            txt_Display.setText("Make sure that your entered values are suitable.");
        }
        
    }
    
    private int toInt(String ip){
        String[] ipList = ip.split("\\.");
        byte[] bytes = new byte[4];
        
        for(int i = 0; i < 4; i++){
            bytes[i] = (byte) Integer.parseInt(ipList[i]);
        }
        
        return ((bytes[0]) << 24) | ((bytes[1]) << 16) |
               ((bytes[2]) << 8) | bytes[3];
    }
    
    private String toIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." +
               ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
    }
    
    private boolean checkRange(String ip){
        String[] list = ip.split("\\.");
        boolean bool = true;
        
        for(String element : list){
            if(Integer.parseInt(element) < 0 || Integer.parseInt(element) > 255){
                bool = false;
            }
        }
        
        return bool;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Calculate;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_Display;
    private javax.swing.JTextField txt_IP;
    private javax.swing.JTextField txt_SubnetMask;
    private javax.swing.JTextField txt_TotalSubnets;
    // End of variables declaration//GEN-END:variables
}
