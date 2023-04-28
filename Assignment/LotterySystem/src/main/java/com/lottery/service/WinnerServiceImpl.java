package com.lottery.service;

import java.util.HashSet;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WinnerServiceImpl implements WinnerService{
	
	private HashSet<Integer> lotteryIds=new HashSet<>();
	
    private boolean isServiceUp=true;

	@Override
	public void addWinningNumbers(HashSet<Integer> numbers) {
		lotteryIds.clear();
		lotteryIds=numbers;
	}

	@Override
	public boolean checkNumber(int num) throws Exception {
		if(!isServiceUp) {
			throw new Exception("service is currently down. Please try again later.");
		}
		return lotteryIds.contains(num);
	}
	
	@Override
	@Scheduled(cron="0 0 6 * * *")
    public void stopWinnerService() {
		isServiceUp=false;
    }

	@Override
    @Scheduled(cron="0 10 6 * * *")
    public void startWinnerService() {
    	isServiceUp=true;
    }

}
