package com.sing3demons.products_backend.business;

import com.sing3demons.products_backend.exception.BaseException;


public class EmailBusiness {


    public void sendActivateUserEmail(String email, String name, String token) throws BaseException {
        // prepare content (HTML)
//        String html;
//        try {
//            html = readEmailTemplate("email-activate-user.html");
//        } catch (IOException e) {
//            throw EmailException.templateNotFound();
//        }
//
//        String finalLink = "http://localhost:4200/activate/" + token;
//        html = html.replace("${P_NAME}", name);
//        html = html.replace("${LINK}", finalLink);

        // prepare subject
//        String subject = "Please activate your account";
//
//        emailService.send(email, subject, html);
    }

//    private String readEmailTemplate(String filename) throws IOException {
//        File file = ResourceUtils.getFile("classpath:email/" + filename);
//        return FileCopyUtils.copyToString(new FileReader(file));
//    }
}
