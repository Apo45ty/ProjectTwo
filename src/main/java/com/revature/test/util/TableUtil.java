package com.revature.test.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.test.model.MockBatch;

public class TableUtil {
	// Send it the Table Container
	public boolean isThisListofWebElementsaHtmlTable(List<WebElement> parmHtmlTable) {
		System.out.println(parmHtmlTable);
		for(WebElement temp : parmHtmlTable)
		
			
		return false;
		return false;
	}
	// *[@id="view"]/div/md-card/md-content/md-table-container/table
	// *[@id="view"]/div/md-card/md-content/md-table-container

//	List<WebElement> tableRows = wd.findElements(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));for(
//	WebElement eachRow:tableRows)
//	{
//		List<WebElement> tableCell = eachRow.findElements(By.tagName("td"));
//		for (WebElement eachCellColoum : tableCell) {
//			System.out.println(eachCellColoum.getText());
//		}
//	}
//}

	public boolean isTableEmpty(List<WebElement> parmHtmlTable) {

		return false;
	}
	public static List<MockBatch> getMockBatch(List<WebElement> parmHtmlTableBodyRow){
		List<MockBatch> rowsOfBatchesOne = new ArrayList<MockBatch>();
		try {
			
			/* Goes through and takes each of the table cells and put its in a Mock Batch
			 *Object then its placed in a List of Batches in the order displayed on the
			 *page
			 */
			for (WebElement eachRow : parmHtmlTableBodyRow) {
				List<WebElement> tableCell = eachRow.findElements(By.tagName("td"));
				ArrayList<String> cellValues = new ArrayList<String>();
				for (WebElement eachCellColoum : tableCell) {
					//System.out.println(eachCellColoum.getText());
					if ((eachCellColoum.getText() == null) || (eachCellColoum.getText() == ""))
						cellValues.add("_");
					else
						cellValues.add(eachCellColoum.getText());
				}
				//For Debugging
				//System.out.println(cellValues.size());
				//System.out.println("---------------------------");
				if(cellValues.size()<2)// any value over 1 would work 2 just seem like a nice number to be extra sure
					 continue;				
				MockBatch currentRow = new MockBatch(cellValues.get(0), cellValues.get(1),cellValues.get(2), cellValues.get(3), cellValues.get(4), cellValues.get(5), cellValues.get(6), cellValues.get(7));
				rowsOfBatchesOne.add(currentRow);

			}
			// Are put into the Collection to utilize the collection sort function.

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println(e.getClass().getName());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
		
		
		
		return rowsOfBatchesOne;	
	}
}
