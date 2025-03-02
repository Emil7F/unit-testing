package pl.emil7f.order;

import java.io.*;

public class OrderBackup {
    private Writer writer;

    public Writer getWriter() {
        return this.writer;
    }

    public void createFile() throws FileNotFoundException {
        String resourcesPath = "C:\\Users\\emilf\\IdeaProjects\\unit-testing-java\\src\\test\\resources";
        File file = new File(resourcesPath + "\\orderBackUp.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    public void backupOrder(Order order) throws IOException {
        if(writer == null){
            throw new IOException("Backup file not created");
        }
        writer.append(order.toString());
    }

    public void closeFile() throws IOException {
        writer.close();
    }

}
