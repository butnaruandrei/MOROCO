/*
 This code loads the MOROCO data set into memory. It is provided for convenience.
 The data set can be downloaded from <https://github.com/butnaruandrei/MOROCO>.
 
 Copyright (C) 2018  Andrei M. Butnaru, Radu Tudor Ionescu
 
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or any
 later version.
 
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.*;
import java.util.*;

public class DataSetLoader
{
    private String inputDataPrefix;
    
    public Vector<String> trainIDs;
    public Vector<String> trainSamples;
    public Vector<String> trainDialectLabels;
    public Vector<String> trainCategoryLabels;
    
    public Vector<String> validationIDs;
    public Vector<String> validationSamples;
    public Vector<String> validationDialectLabels;
    public Vector<String> validationCategoryLabels;
    
    public Vector<String> testIDs;
    public Vector<String> testSamples;
    public Vector<String> testDialectLabels;
    public Vector<String> testCategoryLabels;
    
    public DataSetLoader()
    {
        // Assume the data set is in the below subfolder
        this.inputDataPrefix = "./MOROCO/preprocessed/";
        
        this.trainIDs = new Vector<String>();
        this.trainSamples = new Vector<String>();
        this.trainDialectLabels = new Vector<String>();
        this.trainCategoryLabels = new Vector<String>();
        
        this.validationIDs = new Vector<String>();
        this.validationSamples = new Vector<String>();
        this.validationDialectLabels = new Vector<String>();
        this.validationCategoryLabels = new Vector<String>();
        
        this.testIDs = new Vector<String>();
        this.testSamples = new Vector<String>();
        this.testDialectLabels = new Vector<String>();
        this.testCategoryLabels = new Vector<String>();
    }

    // Loads the samples in the train, validation, or test set
    public void loadMOROCODataSamples(String subsetName, Vector<String> IDs, Vector<String> samples, Vector<String> dialectLabels, Vector<String> categoryLabels)
    {
        String row;
        String[] components;
        String[] sample;
        
        try
        {
            String inputSamplesFilePath = inputDataPrefix + subsetName + "/samples.txt";
            String inputDialectLabelsFilePath = inputDataPrefix + subsetName + "/dialect_labels.txt";
            String inputCategoryLabelsFilePath = inputDataPrefix + subsetName + "/category_labels.txt";
            
            // Loading the data samples
            BufferedReader inputSamplesFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputSamplesFilePath), "UTF-8"));
            row = inputSamplesFile.readLine();
        
            while (row != null)
            {
                components = row.split("\t");
                IDs.add(components[0]);
                sample = Arrays.copyOfRange(components, 1, components.length);
                samples.add(String.join(" ", sample));
                
                row = inputSamplesFile.readLine();
            }
            
            inputSamplesFile.close();
            
            // Loading the dialect labels
            BufferedReader inputDialectLabelsFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputDialectLabelsFilePath), "UTF-8"));
            row = inputDialectLabelsFile.readLine();
            
            while (row != null)
            {
                components = row.split("\t");
                dialectLabels.add(components[1]);
                
                row = inputDialectLabelsFile.readLine();
            }
            
            inputDialectLabelsFile.close();
            
            // Loading the category labels
            BufferedReader inputCategoryLabelsFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputCategoryLabelsFilePath), "UTF-8"));
            row = inputCategoryLabelsFile.readLine();
            
            while (row != null)
            {
                components = row.split("\t");
                categoryLabels.add(components[1]);
                
                row = inputCategoryLabelsFile.readLine();
            }
            
            inputCategoryLabelsFile.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
        
        // IDs[i] is the ID of the sample samples[i] with the dialect label dialectLabels[i] and the category label categoryLabels[i]
    }

    public static void main(String[] args)
    {
        DataSetLoader loader = new DataSetLoader();

        loader.loadMOROCODataSamples("train", loader.trainIDs, loader.trainSamples, loader.trainDialectLabels, loader.trainCategoryLabels);
        System.out.println("Loaded " + loader.trainSamples.size() + " training samples...");
        
        loader.loadMOROCODataSamples("validation", loader.validationIDs, loader.validationSamples, loader.validationDialectLabels, loader.validationCategoryLabels);
        System.out.println("Loaded " + loader.validationSamples.size() + " training samples...");
        
        loader.loadMOROCODataSamples("test", loader.testIDs, loader.testSamples, loader.testDialectLabels, loader.testCategoryLabels);
        System.out.println("Loaded " + loader.testSamples.size() + " test samples...");
        
        /*
        The MOROCO data set is now loaded in the memory.
        Implement your own code to train and evaluation your own model from this point on.
        Perhaps you want to return the variables or transform them into your preferred format first...
         */
    }
}
