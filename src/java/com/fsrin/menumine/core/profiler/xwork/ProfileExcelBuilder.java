/*
 * Created on Aug 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * 
 * 
 */
public class ProfileExcelBuilder {

    public HSSFWorkbook buildExcelWorkbook(Profile bigPicture,
            Collection applications, Collection operatorShare,
            Collection segmentShare, Collection sectorShare) {

        // Collection results = this.getStatisticalTableResults2();

        /*
         * 2006-02-09 rsc this builds a multi worksheet workbook.
         */

        HSSFWorkbook workbook = new HSSFWorkbook();

        this.buildProfileOperationAggregation(bigPicture, workbook);

        this.rowNumber = 0;
        this.buildApplicationsSheet(applications, workbook);

        this.rowNumber = 0;
        this.buildOperatorShareSheet(operatorShare, workbook);

        this.rowNumber = 0;
        this.buildSegmentShareSheet(segmentShare, workbook);

        this.rowNumber = 0;
        this.buildSectorShareSheet(sectorShare, workbook);

        return workbook;
    }

    private void buildProfileOperationAggregation(
            Profile profileOperationAggregation,
            HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet("Profile Operation Aggregation");

        HSSFRow numberOfOperatorsInMenuMineRow = this.newRow(sheet);
        numberOfOperatorsInMenuMineRow.createCell((short) 0).setCellValue(
                "# Operators In MenuMine");
        numberOfOperatorsInMenuMineRow.createCell((short) 1).setCellValue(
                1409);

        HSSFRow numberOfOperatorsUsingIngredient = this.newRow(sheet);
        numberOfOperatorsUsingIngredient.createCell((short) 0).setCellValue(
                "# Operators Using Ingredient");
        numberOfOperatorsUsingIngredient.createCell((short) 1).setCellValue(
                profileOperationAggregation.getNumberOfOperationsUsing());

        HSSFRow ingredientPenetration = this.newRow(sheet);
        ingredientPenetration.createCell((short) 0).setCellValue(
                "Ingredient Penetration");
        ingredientPenetration.createCell((short) 1).setCellValue(
                profileOperationAggregation.getOperationPenetration());

        HSSFRow totalApplications = this.newRow(sheet);
        totalApplications.createCell((short) 0).setCellValue(
                "Total Applications");
        totalApplications.createCell((short) 1).setCellValue(
                profileOperationAggregation.getTotalApplications());

        HSSFRow applicationsPerOperator = this.newRow(sheet);
        applicationsPerOperator.createCell((short) 0).setCellValue(
                "Applications Per Operator");
        applicationsPerOperator.createCell((short) 1).setCellValue(
                profileOperationAggregation.getNumberOfApplicationsPerOperator());

    }

    private void buildSectorShareSheet(Collection sectorProfile,
            HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet("Sector Share");

        HSSFRow headerRow = this.newRow(sheet);
        headerRow.createCell((short) 0).setCellValue("Application");
        headerRow.createCell((short) 1).setCellValue("# Applications");

        headerRow.createCell((short) 2).setCellValue("Application Share");

        headerRow.createCell((short) 3).setCellValue("# Operations Using");

        headerRow.createCell((short) 4).setCellValue(
                "# Applications Per Operator");

        for (Iterator iter = sectorProfile.iterator(); iter
                .hasNext();) {
            Profile profile = (Profile) iter.next();
            HSSFRow profileRow = this.newRow(sheet);
            profileRow.createCell((short) 0).setCellValue(profile.getName());
            profileRow.createCell((short) 1).setCellValue(
                    profile.getNumberOfApplications());

            profileRow.createCell((short) 2).setCellValue(
                    profile.getApplicationShare());

            profileRow.createCell((short) 3).setCellValue(
                    profile.getNumberOfOperationsUsing());

            profileRow.createCell((short) 4).setCellValue(
                    profile.getNumberOfApplicationsPerOperator());

        }

    }

    private void buildSegmentShareSheet(Collection segmentProfile,
            HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet("Segement Share");

        HSSFRow headerRow = this.newRow(sheet);
        headerRow.createCell((short) 0).setCellValue("Application");
        headerRow.createCell((short) 1).setCellValue("# Applications");

        headerRow.createCell((short) 2).setCellValue("Application Share");

        headerRow.createCell((short) 3).setCellValue("# Operations Using");

        headerRow.createCell((short) 4).setCellValue(
                "# Applications Per Operator");

        for (Iterator iter = segmentProfile.iterator(); iter
                .hasNext();) {

            Profile profile = (Profile) iter.next();
            HSSFRow profileRow = this.newRow(sheet);
            profileRow.createCell((short) 0).setCellValue(profile.getName());
            profileRow.createCell((short) 1).setCellValue(
                    profile.getNumberOfApplications());

            profileRow.createCell((short) 2).setCellValue(
                    profile.getApplicationShare());

            profileRow.createCell((short) 3).setCellValue(
                    profile.getNumberOfOperationsUsing());

            profileRow.createCell((short) 4).setCellValue(
                    profile.getNumberOfApplicationsPerOperator());
        }

    }

    private void buildOperatorShareSheet(Collection operationProfile,
            HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet("Operator Share");

        HSSFRow headerRow = this.newRow(sheet);
        headerRow.createCell((short) 0).setCellValue("Application");
        headerRow.createCell((short) 1).setCellValue("# Applications");

        headerRow.createCell((short) 2).setCellValue("Application Share");

        for (Iterator iter = operationProfile.iterator(); iter
                .hasNext();) {
            Profile profile = (Profile) iter.next();
            HSSFRow profileRow = this.newRow(sheet);
            profileRow.createCell((short) 0).setCellValue(profile.getName());
            profileRow.createCell((short) 1).setCellValue(
                    profile.getNumberOfApplications());

            profileRow.createCell((short) 2).setCellValue(
                    profile.getApplicationShare());

        }

    }

    private void buildApplicationsSheet(Collection applications,
            HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.createSheet("Applications");

        HSSFRow headerRow = this.newRow(sheet);
        headerRow.createCell((short) 0).setCellValue("Application");
        headerRow.createCell((short) 1).setCellValue("# Applications");

        headerRow.createCell((short) 2).setCellValue("Application Share");

        headerRow.createCell((short) 3).setCellValue("# Operations Using");

        headerRow.createCell((short) 4).setCellValue(
                "# Applications Per Operator");

        for (Iterator iter = applications.iterator(); iter.hasNext();) {
            Profile profile = (Profile) iter.next();

            HSSFRow profileRow = this.newRow(sheet);
            profileRow.createCell((short) 0).setCellValue(profile.getName());
            profileRow.createCell((short) 1).setCellValue(
                    profile.getNumberOfApplications());

            profileRow.createCell((short) 2).setCellValue(
                    profile.getApplicationShare());

            profileRow.createCell((short) 3).setCellValue(
                    profile.getNumberOfOperationsUsing());

            profileRow.createCell((short) 4).setCellValue(
                    profile.getNumberOfApplicationsPerOperator());

        }

    }

    private short rowNumber = 0;

    private HSSFRow newRow(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow((short) rowNumber++);
        return row;
    }

}