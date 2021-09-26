package com.stockers.digital.util;

import com.stockers.digital.model.Company;

public class StockersUtil {
	
	private static void sortInOrder(Company[] arr,int left,int right,boolean ascendingOrder) {
		if(left < right) {
			int mid =  (left+right)/2;
			sortInOrder(arr,left,mid,ascendingOrder);
			sortInOrder(arr,mid+1,right,ascendingOrder);
			merge(arr, left,right,mid,ascendingOrder);
		}
		
	}

	private static void merge(Company[] array,int left,int right,int mid, boolean ascendingOrder) {
		int len1 = mid-left+1;
		int len2 = right-mid;
		Company[] leftArray = new Company[len1];
		Company[] rightArray = new Company[len2];
		
		for(int i=0;i<len1;i++) {
			leftArray[i] = array[i+left];
		}
		
		for(int j=0;j<len2;j++) {
			rightArray[j] = array[j+mid+1];
		}
		
		int i = 0;
		int j = 0;
		int k =left;
		
		
		while(i<len1 && j <len2) {
		
			if(ascendingOrder) {
				if(leftArray[i].getStock().getCurrentPrice() <= rightArray[j].getStock().getCurrentPrice()) {
					array[k] = leftArray[i];
					i++;
					
				}else{
					array[k] = rightArray[j];
					j++;
						
				}
				k++;
			}else {
				if(leftArray[i].getStock().getCurrentPrice() >= rightArray[j].getStock().getCurrentPrice()) {
					array[k] = leftArray[i];
					i++;
					
				}else{
					array[k] = rightArray[j];
					j++;
						
				}
				k++;
				
			}
		}
		
		while(i<len1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j<len2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
		
	}

	public static void sort(Company[] companies, boolean ascendingOrder) {
		sortInOrder(companies,0, companies.length-1,ascendingOrder);
		
	}
	
}
