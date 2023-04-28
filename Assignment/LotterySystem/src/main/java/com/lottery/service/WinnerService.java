package com.lottery.service;

import java.util.HashSet;

public interface WinnerService {
	
	public void addWinningNumbers(HashSet<Integer> numbers);
	
	public boolean checkNumber(int num)throws Exception;
	
	public void stopWinnerService();
	
	public void startWinnerService();

}
