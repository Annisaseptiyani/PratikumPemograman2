package Tugas2;
    import java.awt.event.*;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import javax.swing.*;
    import javax.swing.SpinnerDateModel;
    
    public class Tugas2 extends JFrame {
    
        JTextArea txtOutput; 
        JTextField textField; 
        JRadioButton radioButton1, radioButton2, radioButton3;
        JList<String> listTabungan;
        JSpinner spinnerTransaksi;
        JSpinner spinnerTanggalLahir; 
        JPasswordField passwordField, confirmPasswordField;
    
        public Tugas2() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Form Pendaftaran");
    
            // Membuat JMenuBar dan Menu
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Menu");
    
            // Membuat MenuItem Reset
            JMenuItem menuItemReset = new JMenuItem("Reset");
            menuItemReset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(""); 
                    listTabungan.clearSelection();
                    txtOutput.setText("");
                    radioButton1.setSelected(true);
                    spinnerTransaksi.setValue(1);
                    passwordField.setText(""); 
                    confirmPasswordField.setText("");
                    spinnerTanggalLahir.setValue(new Date());
                }
            });
    
            // Membuat MenuItem Exit
            JMenuItem menuItemExit = new JMenuItem("Exit");
            menuItemExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
    
            menu.add(menuItemReset);
            menu.add(menuItemExit);
            menuBar.add(menu);
            this.setJMenuBar(menuBar);
    
            // Membuat komponen lain
            JLabel labelInput = new JLabel("Nama:");
            labelInput.setBounds(20, 20, 100, 20); // x, y, width, height
    
            textField = new JTextField(); 
            textField.setBounds(150, 20, 200, 25);
    
            JLabel labelRadio = new JLabel("Jenis Member :");
            labelRadio.setBounds(20, 60, 100, 20);
    
            radioButton1 = new JRadioButton("Silver", true);
            radioButton1.setBounds(150, 60, 100, 25);
    
            radioButton2 = new JRadioButton("Gold", false);
            radioButton2.setBounds(250, 60, 100, 25);
    
            radioButton3 = new JRadioButton("Platinum", false);
            radioButton3.setBounds(350, 60, 100, 25);
    
            ButtonGroup bg = new ButtonGroup();
            bg.add(radioButton1);
            bg.add(radioButton2);
            bg.add(radioButton3);
    
            JLabel labelList = new JLabel("Pilih jenis Tabungan:");
            labelList.setBounds(20, 100, 150, 20);
    
            String[] jenisTabungan = {"Tabungan Regular", "Tabungan Anak", "Tabungan Haji", "Tabungan Pensiun"};
            listTabungan = new JList<>(jenisTabungan);
            listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(listTabungan);
            scrollPane.setBounds(150, 100, 200, 60);
    
            JLabel labelSpinner = new JLabel("Frekuensi Transaksi per Bulan:");
            labelSpinner.setBounds(20, 180, 200, 20);
    
            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
            spinnerTransaksi = new JSpinner(spinnerModel);
            spinnerTransaksi.setBounds(220, 180, 130, 25);
    
            // Tanggal Lahir
            JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
            labelTanggalLahir.setBounds(20, 220, 100, 20);
    
            SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
            spinnerTanggalLahir = new JSpinner(dateModel);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
            spinnerTanggalLahir.setEditor(dateEditor);
            spinnerTanggalLahir.setBounds(150, 220, 200, 25);
    
            // Password
            JLabel labelPassword = new JLabel("Password:");
            labelPassword.setBounds(20, 260, 100, 20);
    
            passwordField = new JPasswordField();
            passwordField.setBounds(150, 260, 200, 25);
    
            JLabel labelConfirmPassword = new JLabel("Confirm Password:");
            labelConfirmPassword.setBounds(20, 300, 150, 20);
    
            confirmPasswordField = new JPasswordField();
            confirmPasswordField.setBounds(150, 300, 200, 25);
    
            // Tombol dan output
            JButton button = new JButton("Klik");
            button.setBounds(150, 340, 200, 25);
    
            txtOutput = new JTextArea();
            JScrollPane outputScrollPane = new JScrollPane(txtOutput);
            outputScrollPane.setBounds(20, 380, 440, 150);
    
            // Tambah semua komponen ke JFrame
            this.setLayout(null); // Menggunakan null layout
            this.add(labelInput);
            this.add(textField);
            this.add(labelRadio);
            this.add(radioButton1);
            this.add(radioButton2);
            this.add(radioButton3);
            this.add(labelList);
            this.add(scrollPane);
            this.add(labelSpinner);
            this.add(spinnerTransaksi);
            this.add(labelTanggalLahir);
            this.add(spinnerTanggalLahir);
            this.add(labelPassword);
            this.add(passwordField);
            this.add(labelConfirmPassword);
            this.add(confirmPasswordField);
            this.add(button);
            this.add(outputScrollPane);
    
            // Action Listener untuk tombol
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String jenisMember = radioButton1.isSelected() ? radioButton1.getText() :
                                        radioButton2.isSelected() ? radioButton2.getText() :
                                        radioButton3.isSelected() ? radioButton3.getText() : "";
    
                    String jenisTabunganDipilih = listTabungan.getSelectedValue();
                    if (jenisTabunganDipilih == null) {
                        jenisTabunganDipilih = "Belum memilih jenis tabungan";
                    }
    
                    String nama = textField.getText();
                    int frekuensiTransaksi = (int) spinnerTransaksi.getValue();
                    Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String tanggalLahirStr = sdf.format(tanggalLahir);
    
                    String password = new String(passwordField.getPassword());
                    String confirmPassword = new String(confirmPasswordField.getPassword());
    
                    txtOutput.setText(""); 
                    txtOutput.append("Hello, " + nama + "\n");
                    txtOutput.append("Anda adalah member " + jenisMember + "\n");
                    txtOutput.append("Jenis tabungan yang dipilih: " + jenisTabunganDipilih + "\n");
                    txtOutput.append("Frekuensi transaksi per bulan: " + frekuensiTransaksi + "\n");
                    txtOutput.append("Tanggal lahir: " + tanggalLahirStr + "\n");
    
                    if (password.equals(confirmPassword)) {
                        txtOutput.append("Password cocok.\n");
                    } else {
                        txtOutput.append("Password tidak cocok.\n");
                    }
                }
            });
    
            // Set ukuran JFrame
            this.setSize(500, 600);
            this.setVisible(true);
        }
    
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Tugas2();
                }
            });
        }
    }
    
    

