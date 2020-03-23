package com.portfolio;

/*
 * PortfolioUtils
 * 
 * Methods used to determine changes to portfolio.
 * 
 */
public class PortfolioUtils {

	/*
	 * determineAllocation
	 * 
	 * Determine the current fund distributed compared to specied risk level. Calculates differences.
	 * 
	 */
	public static boolean determineAllocation(Portfolio portfolio, double totalFunds, double[] funds, CategoryInfo[] info) {
		boolean allocationCorrect = true;
		for (int i = 0; i < info.length; i++) {
			info[i] = new CategoryInfo();
			info[i].setIndex(i);
			info[i].setValue(roundValue(funds[i]));
			info[i].setChangeNeeded(roundValue(Math.abs((totalFunds * ((double)portfolio.getCategoryValue(i) / 100)) - funds[i])));
			info[i].setPercentOfTotal(roundValue((funds[i] / totalFunds) * 100));
			info[i].setPercentDifferent(roundValue(Math.abs(info[i].getPercentOfTotal() - portfolio.getCategoryValue(i))));
			if (info[i].getPercentDifferent() > Constants.DEVIATION_PERCENT) {
				allocationCorrect = false;
			}
						
			if (roundValue(info[i].getPercentOfTotal()) < roundValue(portfolio.getCategoryValue(i))) {
				info[i].setValueLow(true);;
			} else if (roundValue(info[i].getPercentOfTotal()) > roundValue(portfolio.getCategoryValue(i))) {
				info[i].setValueHigh(true);;
			}
		}
		return allocationCorrect;
	}

	public static double roundValue(double value) {
		double roundedValue = (double)value * 100;
		roundedValue = Math.round(roundedValue);
		roundedValue /= 100;
		return roundedValue;
	}
	
	/*
	 * adjustAllocation
	 * 
	 * Produce and record a transaction in the process of adjusting funds.
	 * 
	 */
	public static Transaction adjustAllocation(String[] names, double[] funds, CategoryInfo[] info) {

		double value;
		CategoryInfo infoHighest = findHighest(info);
		CategoryInfo infoLowest = findLowest(info);

		if (infoHighest.getChangeNeeded() > infoLowest.getChangeNeeded()) {
			value = roundValue(infoLowest.getChangeNeeded());
		}
		else {
			value = roundValue(infoHighest.getChangeNeeded());
		}

		funds[infoLowest.getIndex()] += value;
		funds[infoHighest.getIndex()] -= value;

		return new Transaction(value, names[infoHighest.getIndex()], names[infoLowest.getIndex()]);
	}

	/*
	 * findHighest
	 * 
	 * Find the fund that has the highest value over the recommended fund value.
	 * 
	 */
	public static CategoryInfo findHighest(CategoryInfo[] info) {
		int entry = 0;
		double highestValue = 0.0;
		for (int i = 0; i < info.length; i++) {
			if (info[i].isValueHigh() && info[i].getChangeNeeded() > highestValue) {
				highestValue = info[i].getChangeNeeded();
				entry = i;
			}
		}

		if (highestValue == 0) {
			for (int i = 0; i < info.length; i++) {
				if (info[i].getChangeNeeded() > highestValue) {
					highestValue = info[i].getChangeNeeded();
					entry = i;
				}
			}
		}
		return info[entry];
	}

	/*
	 * findLowest
	 * 
	 * Find the fund that has the lowest value under the recommended fund value.
	 * 
	 */
	public static CategoryInfo findLowest(CategoryInfo[] info) {
		int entry = 0;
		double lowestValue = Double.MAX_VALUE;
		for (int i = 0; i < info.length; i++) {
			if (info[i].isValueLow() && info[i].getChangeNeeded() < lowestValue) {
				lowestValue = info[i].getChangeNeeded();
				entry = i;
			}
		}

		if (lowestValue == Double.MAX_VALUE) {
			for (int i = 0; i < info.length; i++) {
				if (info[i].getChangeNeeded() < lowestValue) {
					lowestValue = info[i].getChangeNeeded();
					entry = i;
				}
			}
		}
		return info[entry];
	}

}
