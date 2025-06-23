package DesignPatternsandPrinciples;
// we are using factory design pattern to
interface Document {
    void open();
}
class WordDoc implements Document {
    public void open() {
        System.out.println("Hi Iam opening Word document");
    }
}
class PdfDoc implements Document {
    public void open() {
        System.out.println("Hi Iam opening PDF document");
    }
}
class ExcelDoc implements Document {
    public void open() {
        System.out.println("Hi Iam opening Excel document");
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}
class WordDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDoc();
    }
}
class PdfDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDoc();
    }
}
class ExcelDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDoc();
    }
}
public class DocumentFactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocFactory();
        Document word = wordFactory.createDocument();
        word.open();
        DocumentFactory pdfFactory = new PdfDocFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        DocumentFactory excelFactory = new ExcelDocFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }

}
