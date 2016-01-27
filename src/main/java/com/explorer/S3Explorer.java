package com.explorer;

import java.util.ArrayList;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Explorer {

	AmazonS3 s3 = new AmazonS3Client();

	public void listBuckets() {

		ArrayList<String> bucketList = new ArrayList<String>();

		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		s3.setRegion(usEast1);
		
		int counter = 0;

		try {
			for (Bucket bucket : s3.listBuckets()) {
				bucketList.add(bucket.getName());
				counter ++;
			}

		} catch (AmazonServiceException ase) {
			System.out.println(ase.getErrorCode());
		}

		System.out.println("You have " + counter + " buckets available");
		System.out.println(bucketList);

	}

	public void listBucketContents(String bucket) {
		try {
			ObjectListing objectListing = s3.listObjects(new ListObjectsRequest().withBucketName(bucket));

			for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
				System.out.println(objectSummary.getKey());
			}

		} catch (AmazonServiceException ase) {
			System.out.println(ase.getErrorMessage());
		}

	}

}
