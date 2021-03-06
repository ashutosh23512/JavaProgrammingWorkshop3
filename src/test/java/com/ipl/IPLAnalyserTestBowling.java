package com.ipl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.opencsv.CSVException;

public class IPLAnalyserTestBowling {
	public final String WicketsCSV = "Wkts.csv";
	public final String RunsCSV = "./Runs.csv";
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	int noOfEntriesruns = 0;
	int noOfEntrieswickets = 0;
	String sortedData = null;

	@Before
	public void setUp() {
		ipl = new IPLAnalyser();

	}

	@Test
	public void BowlingAverage() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.MaximumBowlingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].Player);
	}

	@Test
	public void TopStrikeRates() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.BowlersStrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].Player);
	}

	@Test
	public void BestEconomy() {
		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.BestEconomySort();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Shivam Dube", censusCsv[0].Player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToBestStrikeRateAnd4w5w() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.StrikeRateAnd4w5w();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Imran Tahir", censusCsv[0].Player);
	}

	@Test
	public void StrikeRateAndAverage() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.SortStrikeRateAndAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sortedData);
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].Player);
	}

	@Test
	public void oWicketsAndAverage() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.SortWicketsAndAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}

		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Deepak Chahar", censusCsv[0].Player);
	}

	@Test
	public void BattingAvgAndBowlingAvg() {
		List<String> sortedData = null;
		try {
			noOfEntriesruns = ipl.loadMostRunsCSV(RunsCSV);
			noOfEntrieswickets = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.getBestBowlerAndBattingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals("Andre Russell", sortedData.get(48));
		Assert.assertEquals("Marcus Stoinis", sortedData.get(47));

	}

	@Test
	public void AllRounder() {
		List<String> sortedData = null;
		try {
			noOfEntriesruns = ipl.loadMostRunsCSV(RunsCSV);
			noOfEntrieswickets = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.getAllRounder();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals("Andre Russell", sortedData.get(48));
		Assert.assertEquals("Hardik Pandya", sortedData.get(47));

	}

}
