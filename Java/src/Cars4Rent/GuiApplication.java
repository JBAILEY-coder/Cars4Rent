package Cars4Rent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static Cars4Rent.Main.*;

public class GuiApplication {
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();
    static JPanel panel5 = new JPanel();
    static JPanel panel6 = new JPanel();
    static JPanel panel8 = new JPanel();
    static JPanel panel9 = new JPanel();
    static JPanel panel10 = new JPanel();
    static JPanel panel15 = new JPanel();
    static JPanel splash = new JPanel();
    static JFrame frame = new JFrame();
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //days array that contains the number of days in each month

    static Button viewVehicle;
    static Button searchVehicle;
    static Button myRental;
    static Button returnVehicle;
    static Button exit;
    JProgressBar bar = new JProgressBar();

    public GuiApplication() {
        splash.setBackground(new Color(122, 73, 165));
        splash.setBounds(0, 0, 250, 250);
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Cars4Rent Renting System");
        welcomeLabel.setFont(new Font("Comic Sans", Font.ITALIC, 25));
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(100, 100));
        bar.setBackground(new Color(122, 73, 165));
        splash.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10)); //margin
        frame.setVisible(true);
        frame.add(splash);
        frame.add(bar, BorderLayout.SOUTH);
        if (fill() == 100) {
            Button start = new Button("Welcome to Cars4Rent");
            start.setPreferredSize(new Dimension(100, 100));
            start.setFocusable(false);
            frame.remove(bar);
            frame.add(start, BorderLayout.SOUTH);
            start.addActionListener(j -> {
                frame.remove(splash);
                frame.remove(bar);
                frame.remove(start);
                viewVehicle = new Button("View Vehicles");
                viewVehicle.setFocusable(false);
                viewVehicle.setPreferredSize(new Dimension(100, 100));
                viewVehicle.setBackground(new Color(122, 73, 165));
                searchVehicle = new Button("Search Vehicle");
                searchVehicle.setFocusable(false);
                searchVehicle.setPreferredSize(new Dimension(100, 100));
                searchVehicle.setBackground(new Color(122, 73, 165));
                myRental = new Button("View Your Rentals");
                myRental.setFocusable(false);
                myRental.setPreferredSize(new Dimension(100, 100));
                myRental.setBackground(new Color(122, 73, 165));
                returnVehicle = new Button("Return Vehicle");
                returnVehicle.setFocusable(false);
                returnVehicle.setPreferredSize(new Dimension(100, 100));
                returnVehicle.setBackground(new Color(122, 73, 165));
                exit = new Button("Exit");
                exit.setFocusable(false);
                exit.setPreferredSize(new Dimension(100, 100));
                exit.setBackground(new Color(122, 73, 165));
                JLabel groupMembers = new JLabel("Group Members: ");
                JLabel name1 = new JLabel("J'Nelle Bailey");
                JLabel name2 = new JLabel("Kayla Mullings");
                JLabel name3 = new JLabel("Janique Graham");
                JLabel name4 = new JLabel("Nicholas Thomas");
                JLabel label = new JLabel();
                label.setText("Cars4Rent Renting System");
                label.setFont(new Font("Comic Sans", Font.ITALIC, 25));
                panel1.add(label);
                panel2.setBackground(new Color(122, 73, 165));
                panel3.setBackground(Color.white);
                panel4.setBackground(Color.magenta);
                panel5.setBackground(Color.white);
                panel2.add(viewVehicle);
                panel2.add(searchVehicle);
                panel2.add(myRental);
                panel2.add(returnVehicle);
                panel2.add(exit);


                panel1.setPreferredSize(new Dimension(100, 50));
                panel2.setPreferredSize(new Dimension(100, 100));
                panel3.setPreferredSize(new Dimension(50, 100));
                panel4.setPreferredSize(new Dimension(100, 50));
                panel5.setPreferredSize(new Dimension(50, 100));

                panel4.add(groupMembers);
                panel4.add(name1);
                panel4.add(name2);
                panel4.add(name3);
                panel4.add(name4);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(panel2, BorderLayout.WEST);
                frame.add(panel3, BorderLayout.EAST);
                frame.add(panel4, BorderLayout.SOUTH);
                frame.add(panel5, BorderLayout.CENTER);
                //---------sub panels


                panel6.setBackground(Color.lightGray);
                panel8.setBackground(Color.gray);
                panel9.setBackground(Color.lightGray);
                panel10.setBackground(Color.white);
                panel15.setBackground(Color.CYAN);


                panel5.setLayout(new BorderLayout());

                panel6.setPreferredSize(new Dimension(50, 50));
                panel8.setPreferredSize(new Dimension(50, 50));
                panel9.setPreferredSize(new Dimension(120, 50));
                panel10.setPreferredSize(new Dimension(50, 50));
                panel15.setPreferredSize(new Dimension(50, 50));

                panel5.add(panel6, BorderLayout.NORTH);
                panel5.add(panel9, BorderLayout.WEST);
                panel5.add(panel15, BorderLayout.CENTER);
                panel5.add(panel10, BorderLayout.CENTER);
                panel10.setVisible(false);
                panel15.setVisible(false);

                viewVehicleButton();
                searchVehicleButton();
                myRentalButton();
                returnVehicleButton();
                exitButton();

            });
        }
    }

    public int fill() {
        int i = 0;
        for (int k = 0; k <= 100; k++) {
            bar.setValue(k);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = k;
        }
        return i;
    }

    static void exitButton() {
        exit.addActionListener(h -> {
            frame.dispose();
        });
    }

    static void returnVehicleButton() {
        returnVehicle.addActionListener(m -> {
            panel6.removeAll();
            JLabel rentTitle = new JLabel("Return Your Vehicle");
            rentTitle.setFont(new Font("Comic Sans", Font.ITALIC, 15));
            panel6.add(rentTitle);
            panel9.setVisible(false);
            panel10.removeAll();
            panel10.setVisible(true);
            Button submit = new Button("Submit");
            Button clear = new Button("Clear");
            submit.setFocusable(false);
            clear.setFocusable(false);

            JLabel licensePlateNumber = new JLabel("License Plate Number");
            JTextField license = new JTextField();
            license.setPreferredSize(new Dimension(10, 10));
            JLabel returnDate = new JLabel("Enter today's date (dd/MM/yyyy)");
            JTextField carReturnDate = new JTextField();
            carReturnDate.setPreferredSize(new Dimension(10, 10));
            JLabel cMileage = new JLabel("Enter the current mileage");
            JTextField mileage = new JTextField();
            mileage.setPreferredSize(new Dimension(8, 10));
            JPanel panel11 = new JPanel(new GridLayout(4, 2));
            panel11.setBackground(Color.pink);
            panel11.setPreferredSize(new Dimension(450, 100));
            panel11.add(licensePlateNumber);
            panel11.add(license);
            panel11.add(returnDate);
            panel11.add(carReturnDate);
            panel11.add(cMileage);
            panel11.add(mileage);
            panel11.add(submit);
            panel11.add(clear);
            panel10.add(panel11);
            submit.addActionListener(q -> {
                String[] todayReturn;
                String[] check;
                String cReturnDate = carReturnDate.getText();
                todayReturn = cReturnDate.split("/");
                if ((Integer.parseInt(todayReturn[1]) > 12) || (Integer.parseInt(todayReturn[0]) > days[Integer.parseInt(todayReturn[1]) - 1]) || (Integer.parseInt(todayReturn[0]) < 0)) {
                    JOptionPane.showMessageDialog(frame, "Error! Incorrect date...Please re-enter the date");
                    carReturnDate.setText(null);
                } else {
                    Button continu = new Button("Return another Rental Vehicle");
                    check = returnVehicle(license.getText().toUpperCase(), carReturnDate.getText(), mileage.getText());
                    if (check[0].equals("1")) {
                        JOptionPane.showMessageDialog(frame, "Rental found");
                        JTextArea view = new JTextArea(receipt(Integer.parseInt(check[1]), Integer.parseInt(check[2]), Double.parseDouble(check[3]), Integer.parseInt(check[4])));
                        view.setBounds(500, 0, 0, 0);
                        panel10.remove(panel11);
                        panel10.add(view);
                        license.setText(null);
                        carReturnDate.setText(null);
                        mileage.setText(null);
                        panel10.add(continu);
                        JOptionPane.showMessageDialog(frame, "Vehicle was successfully rented");
                        continu.addActionListener(w -> {
                            panel10.remove(view);
                            panel10.add(panel11);
                            panel10.remove(continu);
                        });
                    } else {
                        JOptionPane.showMessageDialog(frame, "Rental not found");
                        license.setText(null);
                        carReturnDate.setText(null);
                        mileage.setText(null);
                    }
                }
            });
            clear.addActionListener(q -> {
                license.setText(null);
                carReturnDate.setText(null);
                mileage.setText(null);
            });
        });
    }

    static void myRentalButton() {
        myRental.addActionListener(e -> {
            panel9.removeAll();
            panel6.removeAll();
            JLabel rentTitle = new JLabel("View Your Vehicles");
            rentTitle.setFont(new Font("Comic Sans", Font.ITALIC, 15));
            panel6.add(rentTitle);
            panel10.removeAll();
            panel10.setVisible(true);
            Button submit9 = new Button("Submit");
            JLabel cName = new JLabel("Enter your name");
            JTextField cusName = new JTextField();
            cusName.setPreferredSize(new Dimension(100, 20));
            submit9.setBounds(500, 500, 10, 10);
            submit9.setFocusable(false);

            panel10.add(cName);
            panel10.add(cusName);
            panel10.add(submit9);
            submit9.addActionListener(h -> {
                JTextArea view;
                int check;
                String customer = cusName.getText().toUpperCase();
                check = myRental(customer);
                if (check == 0) {
                    JOptionPane.showMessageDialog(frame, "Customer did not rent a car");
                    cusName.setText(null);
                    panel10.removeAll();
                    panel10.add(cName);
                    panel10.add(cusName);
                    panel10.add(submit9);
                } else {
                    panel10.removeAll();
                    panel10.add(cName);
                    panel10.add(cusName);
                    panel10.add(submit9);
                    view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    panel10.add(view, BorderLayout.CENTER);
                    cusName.setText(null);
                }
            });
        });
    }

    static void searchVehicleButton() {
        searchVehicle.addActionListener(a -> {
            panel6.removeAll();
            JLabel rentTitle = new JLabel("Rent A Vehicle");
            rentTitle.setFont(new Font("Comic Sans", Font.ITALIC, 15));
            panel6.add(rentTitle);
            panel9.removeAll();
            panel9.setVisible(true);
            panel10.removeAll();
            panel10.setVisible(true);
            JLabel label = new JLabel("Choose one feature");
            JLabel label1 = new JLabel("to search");
            Button license = new Button("License Plate Number");
            license.setFocusable(false);
            Button brand = new Button("Brand");
            brand.setFocusable(false);
            Button model = new Button("Model");
            model.setFocusable(false);
            Button year = new Button("Year");
            year.setFocusable(false);
            Button interior = new Button("Interior");
            interior.setFocusable(false);
            Button submit = new Button("Submit");
            submit.setFocusable(false);
            JPanel panel16 = new JPanel(new GridLayout(10, 2));
            panel9.add(label);
            panel9.add(label1);
            panel9.add(license);
            panel9.add(brand);
            panel9.add(model);
            panel9.add(year);
            panel9.add(interior);
            panel15.add(panel16);
            //------------------------------------
            interior.addActionListener(m -> {
                Button submit7 = new Button("Submit");
                submit7.setFocusable(false);
                panel10.removeAll();
                JLabel cInterior = new JLabel("Enter the interior type");
                JTextField carInterior = new JTextField();
                carInterior.setPreferredSize(new Dimension(100, 20));
                panel10.add(cInterior);
                panel10.add(carInterior);
                panel10.add(submit7);
                submit7.addActionListener(c -> {
                    Button submit8 = new Button("Submit");
                    submit8.setFocusable(false);
                    Button cancel8 = new Button("Cancel");
                    cancel8.setFocusable(false);
                    String carI = carInterior.getText().substring(0, 1).toUpperCase() + carInterior.getText().substring(1).toLowerCase();
                    findVehicle(carI, 15);
                    JTextArea view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    rentalField(carInterior, view, submit8, cancel8);
                });
            });
            year.addActionListener(m -> {
                Button submit5 = new Button("Submit");
                submit5.setFocusable(false);
                panel10.removeAll();
                JLabel cYear = new JLabel("Enter the year");
                JTextField carYear = new JTextField();
                carYear.setPreferredSize(new Dimension(100, 20));
                panel10.add(cYear);
                panel10.add(carYear);
                panel10.add(submit5);
                submit5.addActionListener(c -> {
                    Button submit6 = new Button("Submit");
                    submit6.setFocusable(false);
                    Button cancel6 = new Button("Cancel");
                    cancel6.setFocusable(false);
                    String carY = carYear.getText() + ".0";
                    findVehicle(carY, 5);
                    JTextArea view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    rentalField(carYear, view, submit6, cancel6);
                });
            });
            model.addActionListener(l -> {
                Button submit3 = new Button("Submit");
                submit3.setFocusable(false);
                panel10.removeAll();
                JLabel cModel = new JLabel("Enter the model");
                JTextField carModel = new JTextField();
                carModel.setPreferredSize(new Dimension(100, 20));
                panel10.add(cModel);
                panel10.add(carModel);
                panel10.add(submit3);
                submit3.addActionListener(c -> {
                    Button submit5 = new Button("Submit");
                    submit5.setFocusable(false);
                    Button cancel5 = new Button("Cancel");
                    cancel5.setFocusable(false);
                    String carM = carModel.getText().substring(0, 1).toUpperCase() + carModel.getText().substring(1).toLowerCase();
                    findVehicle(carM, 4);
                    JTextArea view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    rentalField(carModel, view, submit5, cancel5);
                });
            });
            brand.addActionListener(l -> {
                Button submit2 = new Button("Submit");
                submit2.setFocusable(false);
                panel10.removeAll();
                JLabel cBrand = new JLabel("Enter the brand");
                JTextField carBrand = new JTextField();
                carBrand.setPreferredSize(new Dimension(100, 20));
                panel10.add(cBrand);
                panel10.add(carBrand);
                panel10.add(submit2);
                submit2.addActionListener(c -> {
                    Button submit4 = new Button("Submit");
                    submit4.setFocusable(false);
                    Button cancel4 = new Button("Cancel");
                    cancel4.setFocusable(false);
                    String carB = carBrand.getText().substring(0, 1).toUpperCase() + carBrand.getText().substring(1).toLowerCase();
                    findVehicle(carB, 3);
                    JTextArea view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    rentalField(carBrand, view, submit4, cancel4);
                });
            });
            license.addActionListener(b -> {
                panel10.removeAll();
                JLabel lPlate = new JLabel("Enter the License Plate Number");
                JTextField plate = new JTextField();
                plate.setPreferredSize(new Dimension(100, 20));
                panel10.add(lPlate);
                panel10.add(plate);
                panel10.add(submit);
                submit.addActionListener(c -> {
                    Button submit1 = new Button("Submit");
                    submit1.setFocusable(false);
                    Button cancel1 = new Button("Cancel");
                    cancel1.setFocusable(false);
                    System.out.println("called");
                    findVehicle(plate.getText().toUpperCase(), 1);
                    JTextArea view = new JTextArea(outputVehicles());
                    view.setBounds(500, 0, 0, 0);
                    rentalField(plate, view, submit1, cancel1);
                });
            });
        });
    }

    static void viewVehicleButton() {
        viewVehicle.addActionListener(e -> {
            panel6.removeAll();
            JLabel rentTitle = new JLabel("Rent A Vehicle");
            rentTitle.setFont(new Font("Comic Sans", Font.ITALIC, 15));
            panel6.add(rentTitle);
            panel9.setVisible(false);
            panel10.removeAll();
            panel10.setVisible(true);

            JTextArea view = new JTextArea(viewVehicle());
            view.setBounds(500, 0, 0, 0);
            viewVehicle(); //view vehicle call output
            panel10.add(view, BorderLayout.CENTER);
            JLabel label1 = new JLabel("Are you renting a vehicle? ");
            Border border = BorderFactory.createDashedBorder(Color.black);
            label1.setBorder(border);
            Button yes = new Button("Yes");
            Button no = new Button("No");
            yes.setBackground(Color.lightGray);
            yes.setFocusable(false);
            no.setBackground(Color.lightGray);
            no.setFocusable(false);
            label1.setBounds(50, 50, 0, 0);
            panel10.add(label1);
            panel10.add(yes);
            panel10.add(no);
            yes.addActionListener(f -> {
                Button submit = new Button("Submit");
                Button cancel = new Button("Cancel");
                label1.setVisible(false);
                yes.setVisible(false);
                no.setVisible(false);
                JLabel licensePlateNumber = new JLabel("License Plate Number");
                JTextField license = new JTextField();
                license.setPreferredSize(new Dimension(10, 10));
                JTextField cName = new JTextField();
                cName.setPreferredSize(new Dimension(10, 10));
                JTextField cAddress = new JTextField();
                cAddress.setPreferredSize(new Dimension(10, 10));
                JTextField phoneNumber = new JTextField();
                phoneNumber.setPreferredSize(new Dimension(10, 10));
                JTextField rentDate = new JTextField();
                rentDate.setPreferredSize(new Dimension(10, 10));
                JTextField dateExpect = new JTextField();
                dateExpect.setPreferredSize(new Dimension(10, 10));
                JTextField cDeposit = new JTextField();
                cDeposit.setPreferredSize(new Dimension(10, 10));
                licensePlateNumber.setBounds(50, 50, 0, 0);
                JLabel name = new JLabel("Customer Name");
                name.setBounds(50, 90, 0, 0);
                JLabel phone = new JLabel("Phone Number");
                JLabel address = new JLabel("Address");
                JLabel dateRented = new JLabel("Date Rented (dd/MM/yyyy)");
                JLabel expectedReturnDate = new JLabel("Expected Return Date (dd/MM/yyyy)");
                JLabel deposit = new JLabel("Deposit");
                submit.setBounds(500, 500, 10, 10);
                JPanel panel11 = new JPanel(new GridLayout(10, 2));
                panel11.setBackground(Color.pink);
                panel11.setPreferredSize(new Dimension(450, 200));
                panel11.add(licensePlateNumber);
                panel11.add(license);
                panel11.add(name);
                panel11.add(cName);
                panel11.add(address);
                panel11.add(cAddress);
                panel11.add(phone);
                panel11.add(phoneNumber);
                panel11.add(dateRented);
                panel11.add(rentDate);
                panel11.add(expectedReturnDate);
                panel11.add(dateExpect);
                panel11.add(deposit);
                panel11.add(cDeposit);
                panel11.add(submit);
                panel11.add(cancel);
                panel10.add(panel11);
                submit.addActionListener(h -> {
                    String[] returnDate1, expectedReturn;
                    String expectDate = dateExpect.getText();
                    String date = rentDate.getText();
                    returnDate1 = date.split("/");
                    expectedReturn = expectDate.split("/");
                    if (((Integer.parseInt(returnDate1[1]) > 12) || (Integer.parseInt(returnDate1[0]) > days[Integer.parseInt(returnDate1[1]) - 1]) || (Integer.parseInt(returnDate1[0]) < 0)) || ((Integer.parseInt(expectedReturn[1]) > 12) || (Integer.parseInt(expectedReturn[0]) > days[Integer.parseInt(expectedReturn[1]) - 1]) || (Integer.parseInt(expectedReturn[0]) < 0))) {
                        JOptionPane.showMessageDialog(frame, "Error! Incorrect date...Please re-enter the date");
                    } else {
                        cancel.setEnabled(false);
                        int rent = rentVehicle(license.getText().toUpperCase(), cName.getText(), cAddress.getText(), phoneNumber.getText(), rentDate.getText(), dateExpect.getText(), cDeposit.getText());
                        if (rent < 3) {
                            JOptionPane.showMessageDialog(frame, "Vehicle successfully rented");
                        }
                        license.setText(null);
                        cName.setText(null);
                        cAddress.setText(null);
                        phoneNumber.setText(null);
                        rentDate.setText(null);
                        dateExpect.setText(null);
                        cDeposit.setText(null);
                        panel11.setVisible(false);
                        label1.setVisible(true);
                        yes.setVisible(true);
                        no.setVisible(true);
                        if (rent == 3) {
                            JOptionPane.showMessageDialog(frame, "Vehicle cannot be rented, you have reached your limit");
                        }
                    }
                });
                cancel.addActionListener(i -> {
                    JOptionPane.showMessageDialog(frame, "Your option was noted");
                    panel11.setVisible(false);
                    label1.setVisible(true);
                    yes.setVisible(true);
                    no.setVisible(true);
                });
            });
            no.addActionListener(g -> JOptionPane.showMessageDialog(frame, "Your option was noted"));
        });
    }

    static void rentalField(JTextField feature, JTextArea view, Button submit, Button cancel) {
        if (outputVehicles().equals("No")) {
            JOptionPane.showMessageDialog(frame, "No Vehicle was found, the vehicle was either rented or does not exist");
            feature.setText(null);
        } else {
            panel10.add(view, BorderLayout.CENTER);
            //rent panel
            JLabel label2 = new JLabel("Are you renting a vehicle? ");
            Border border = BorderFactory.createDashedBorder(Color.black);
            label2.setBorder(border);
            Button yes = new Button("Yes");
            yes.setFocusable(false);
            Button no = new Button("No");
            no.setFocusable(false);
            yes.setBackground(Color.lightGray);
            yes.setFocusable(false);
            no.setBackground(Color.lightGray);
            no.setFocusable(false);
            label2.setBounds(50, 50, 0, 0);
            panel10.add(label2);
            panel10.add(yes);
            panel10.add(no);
            yes.addActionListener(f -> {
                label2.setVisible(false);
                yes.setVisible(false);
                no.setVisible(false);
                JLabel licensePlateNumber = new JLabel("License Plate Number");
                JTextField license1 = new JTextField();
                license1.setPreferredSize(new Dimension(10, 10));
                JTextField cName = new JTextField();
                cName.setPreferredSize(new Dimension(10, 10));
                JTextField cAddress = new JTextField();
                cAddress.setPreferredSize(new Dimension(10, 10));
                JTextField phoneNumber = new JTextField();
                phoneNumber.setPreferredSize(new Dimension(10, 10));
                JTextField rentDate = new JTextField();
                rentDate.setPreferredSize(new Dimension(10, 10));
                JTextField dateExpect = new JTextField();
                dateExpect.setPreferredSize(new Dimension(10, 10));
                JTextField cDeposit = new JTextField();
                cDeposit.setPreferredSize(new Dimension(10, 10));
                licensePlateNumber.setBounds(50, 50, 0, 0);
                JLabel name = new JLabel("Customer Name");
                name.setBounds(50, 90, 0, 0);
                JLabel phone = new JLabel("Phone Number");
                JLabel address = new JLabel("Address");
                JLabel dateRented = new JLabel("Date Rented (dd/MM/yyyy)");
                JLabel expectedReturnDate = new JLabel("Expected Return Date (dd/MM/yyyy)");
                JLabel deposit = new JLabel("Deposit");
                submit.setBounds(500, 500, 10, 10);
                JPanel panel11 = new JPanel(new GridLayout(10, 2));
                panel11.setBackground(Color.pink);
                panel11.setPreferredSize(new Dimension(450, 200));
                panel11.add(licensePlateNumber);
                panel11.add(license1);
                panel11.add(name);
                panel11.add(cName);
                panel11.add(address);
                panel11.add(cAddress);
                panel11.add(phone);
                panel11.add(phoneNumber);
                panel11.add(dateRented);
                panel11.add(rentDate);
                panel11.add(expectedReturnDate);
                panel11.add(dateExpect);
                panel11.add(deposit);
                panel11.add(cDeposit);
                panel11.add(submit);
                panel11.add(cancel);
                panel10.add(panel11);
                //submit the info
                submit.addActionListener(h -> {
                    String[] returnDate1, expectedReturn;
                    String expectDate = dateExpect.getText();
                    String date = rentDate.getText();
                    returnDate1 = date.split("/");
                    expectedReturn = expectDate.split("/");
                    if (((Integer.parseInt(returnDate1[1]) > 12) || (Integer.parseInt(returnDate1[0]) > days[Integer.parseInt(returnDate1[1]) - 1]) || (Integer.parseInt(returnDate1[0]) < 0)) || ((Integer.parseInt(expectedReturn[1]) > 12) || (Integer.parseInt(expectedReturn[0]) > days[Integer.parseInt(expectedReturn[1]) - 1]) || (Integer.parseInt(expectedReturn[0]) < 0))) {
                        JOptionPane.showMessageDialog(frame, "Error! Incorrect date...Please re-enter the date");
                    } else {
                        cancel.setEnabled(false);
                        int rent = rentVehicle(license1.getText().toUpperCase(), cName.getText(), cAddress.getText(), phoneNumber.getText(), rentDate.getText(), dateExpect.getText(), cDeposit.getText());
                        if (rent < 3) {
                            JOptionPane.showMessageDialog(frame, "Vehicle successfully rented");
                        }
                        license1.setText(null);
                        cName.setText(null);
                        cAddress.setText(null);
                        phoneNumber.setText(null);
                        rentDate.setText(null);
                        dateExpect.setText(null);
                        cDeposit.setText(null);
                        panel11.setVisible(false);
                        view.setVisible(false);
                        feature.setText(null);
                        if (rent == 3) {
                            JOptionPane.showMessageDialog(frame, "Vehicle cannot be rented, you have reached your limit");
                        }
                    }
                });
                cancel.addActionListener(d -> {
                    JOptionPane.showMessageDialog(frame, "Your option was noted");
                    panel11.setVisible(false);
                    view.setVisible(false);
                    feature.setText(null);
                });
            });
            no.addActionListener(k -> {
                JOptionPane.showMessageDialog(frame, "Your option was noted");
                label2.setVisible(false);
                yes.setVisible(false);
                no.setVisible(false);
                view.setVisible(false);
                feature.setText(null);
            });
        }
    }
}
