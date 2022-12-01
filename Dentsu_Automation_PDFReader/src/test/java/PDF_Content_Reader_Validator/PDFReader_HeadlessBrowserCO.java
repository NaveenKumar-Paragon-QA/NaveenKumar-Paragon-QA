package PDF_Content_Reader_Validator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDFReader_HeadlessBrowserCO {
	WebDriver driver;
	String url="https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
	
	@BeforeTest
	public void setup() {
		
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		driver = new ChromeDriver(co);
		driver.get(url);
	
	}
	@Test
	public void pdfReaderTest() throws IOException {
		
		URL pdfUrl = new URL(url);
		InputStream ip = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(ip);
		PDDocument pdfDocument = PDDocument.load(bf);
		
	//Page Count:
		int pageCount = pdfDocument.getNumberOfPages();
		System.out.println("pdf page:" +pageCount);
		Assert.assertEquals(pageCount, 4);
		
		
	//Page content/text:
		PDFTextStripper pdfstripper = new PDFTextStripper();
		
		/*String pdfText = pdfstripper.getText(pdfDocument);
		System.out.println(pdfText);
		Assert.assertTrue(pdfText.contains("PDF BOOKMARK SAMPLE"));
		Assert.assertTrue(pdfText.contains("Invoices sorted, ascending, by date"));
		Assert.assertTrue(pdfText.contains("Identify the bookmark file using the -abmk command. "));
		Assert.assertTrue(pdfText.contains("To run this sample, place ap_bookmark.dat in the collector directory scanned by Central. "));*/
	
	// Set page number and get the content:
		pdfstripper.setStartPage(3);
		String pdfText = pdfstripper.getText(pdfDocument);
		System.out.println(pdfText);
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
	

}





