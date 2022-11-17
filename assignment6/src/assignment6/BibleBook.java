package assignment6;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

	public class BibleBook 
	{
        private String book;
        private int chapters;
        private String summary;

        public BibleBook (String book, int chapters, String summary)
        {
            this.book = book;
            this.chapters = chapters;
            this.summary = summary;
        }
        public int getChapters()
        {
           return chapters;
        }
        public String getBook()
        {
           return book;
        }
        public String toString()
        {
            return "Book name: "+this.book+" Chapters: "+this.chapters+" Summary: "+this.summary;
        }
			public static void main(String[] args)
			{			
                BibleBook[] bookArr = new BibleBook[100];
                int count=0;
				try
				{
					Scanner fileIn = new Scanner(new File(System.getProperty("user.dir") + "/src/assignment6/input.dat"));
					while(fileIn.hasNext())
					{
						String line = fileIn.nextLine();
						String array[] = line.split(":");
						
							String book = array[0];
							int chapters = Integer.parseInt(array[1]);
							String summary = array[2];
							BibleBook b=new BibleBook(book,chapters,summary);
                            bookArr[count++] = b;
							//BibleBook.bubbleSort(BibleBook[] bookArr);
						//System.out.println("Book name: " + book + "(" + chapters + " chapters) - " + summary);
					}
					fileIn.close();
					Scanner input = new Scanner (System.in);
					System.out.println("This program displays New Testament books, chapters, and summaries in alphabetical order by book name or chapter order. Provide one of the following two keywords: alphabetical chapter:");
					String s = input.nextLine();
					
					if("chapter".equals(s))
                    {
					bookArr = bubbleSort(bookArr,count);
                    for(int i=0;i<count;i++)
                        System.out.println(bookArr[i]);
                    }
					else if("alphabetical".equals(s))
					{
                    bookArr = AlphaSort(bookArr,count);
                    for(int i=0;i<count;i++)
                        System.out.println(bookArr[i]);
					}
					else
					{
						System.out.println("Invalid entry. Must provide one of the following two keywords: chapter alphabetical");
					}
					input.close();
				}
				catch(Exception e)
				{
				System.err.println(e.toString());
				}
			}
			static BibleBook[] bubbleSort(BibleBook[] bookArr,int count)
			{
			BibleBook temp;
				
				for(int i=0; i < count-1; i++){  
                 for(int j=0; j < (count-i)-1; j++){  
					if(bookArr[j].getChapters() > bookArr[j+1].getChapters())
					{
						temp = bookArr[j];
						bookArr[j] = bookArr[j+1];
						bookArr[j+1] = temp;						
					}
                 }
				}

                return bookArr;
			}
			static BibleBook[] AlphaSort(BibleBook[] bookArr,int count)
			{
			BibleBook temp;
				
				for(int j=0; j < count-1; j++)
				{    
					for (int i = j+1; i<count; i++)
					if(bookArr[j].book.compareTo(bookArr[i].book) > 0)
					{
						temp = bookArr[j];
						bookArr[j] = bookArr[i];
						bookArr[i] = temp;
					}
                 }
				return bookArr;
			}
			}
 
