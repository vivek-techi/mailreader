package TestScript;

import ExcelUtilities.ExcelUtilities;
import common.Constants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

    public class MailReader {

        public static void main( String[] args ) throws Exception {

            MailReader gmail = new MailReader();
                gmail.read();

            }

            public void read() {

                Properties props = new Properties();

                try {
                    props.load(new FileInputStream(new File(Constants.SMTP_FILEPATH)));
                    Session session = Session.getDefaultInstance(props, null);

                    Store store = session.getStore(Constants.PROTOCOL);
                    store.connect(Constants.HOST, Constants.USER_NAME, Constants.USER_PASSWORD);

                    Folder inbox = store.getFolder("inbox");
                    inbox.open(Folder.READ_ONLY);
                    int messageCount = inbox.getMessageCount();

                    System.out.println("Total Messages:- " + messageCount);

                    Message[] messages = inbox.getMessages();
                    System.out.println("------------------------------");

                    for (int msg = 0; msg< 50; msg++) {
                        System.out.println("Mail Subject:- " + messages[msg].getSubject());
                        String sub = messages[msg].getSubject();
                        ExcelUtilities.writetocsvfile(sub,msg+1, Constants.CELL_VALUE0);
                        System.out.println("Mail DATE:- " + messages[msg].getReceivedDate());
                        String date = String.valueOf(messages[msg].getReceivedDate());
                        ExcelUtilities.writetocsvfile(date,msg+1, Constants.CELL_VALUE1);
                        Address[] froms = messages[msg].getFrom();
                        String email = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
                        ExcelUtilities.writetocsvfile(email,msg+1, Constants.CELL_VALUE2);
                        System.out.println("Mail FROM:- " + email);
                    }

                    inbox.close(true);
                    store.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }



