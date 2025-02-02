package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.util.tools.VerificationCodeGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class ForgotPasswordFormController {
    public AnchorPane context;
    public TextField txtEmail;

    public void sendVerificationCodeOnAction(ActionEvent actionEvent) {
        try{
            int verificationCode =  new VerificationCodeGenerator().getCode(5);
            String fromEmail = "pavithriapeksha1new@Gmail.com";
            String toEmail = "pavithriapeksha1new@Gmail.com";
            String host = "smtp.gmail.com";

            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.port", "587");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            Session session = Session.getDefaultInstance(properties);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(fromEmail));
            mimeMessage.setSubject("Verification Code");
            mimeMessage.setText("Verification Code: " + verificationCode);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //Transport.send(mimeMessage);
            System.out.println("Completed !");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CodeVerificationForm.fxml"));
            Parent parent = fxmlLoader.load();
            CodeVerificationFormController controller = fxmlLoader.getController();
            controller.setUserData(verificationCode,txtEmail.getText());
            Stage stage = (Stage) context.getScene().getWindow();
            stage.setScene(new Scene(parent));

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
}
