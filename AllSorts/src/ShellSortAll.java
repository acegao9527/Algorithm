/**
 * Created by wuzhi1234 on 15/7/24.
 */
public class ShellSortAll
{
    private int[]    intArray;            // 待排序的数组
    private int        nItems;                // 数组内元素个数
    private int        maxItems;            // 数组大小
    private int[]    intervalSequence;    // 增量数组序列


    // 构造函数
    public ShellSortAll( int maxItems, int[] intervalSequence )
    {
        this.intArray = new int[maxItems];
        this.maxItems = maxItems;
        this.nItems = 0;// 还没有元素
        this.intervalSequence = intervalSequence;
    }

    /**
     * 49 38 65 97 76 13 27 49 55 4
     *
     * 希尔排序算法，从小到大
     */
    public void shellSortMethod()
    {
        int h = 0;//为增量
        for ( int iIntervalLength = 0; iIntervalLength < intervalSequence.length; iIntervalLength++ )
        //最外层循环，由增量序列元素个数决定
        {
            h = intervalSequence[iIntervalLength];//h为index增量
            int sizeInterArray;//每次内部插入排序的元素个数
            if ( 0 == nItems % h )
            {
                sizeInterArray = nItems/h;
            } else
            {
                sizeInterArray = nItems/h + 1;
            }
            for ( int jZeroToH = 0; jZeroToH < h; jZeroToH++ )//index从 0->h-1 共h-1次循环

            {
                int temp = 0;
                int out = 0,in = 0;
                /**
                 * 例如：
                 * 当h=3,intArray.lenght=10时，sizeInterArray初始化为4，
                 * 当jZeroToH=1，此时的内部插入排序元素index=1,4,7，为3个元素，
                 * 所以应该进行判断，以适应内部插入排序元素减少的情况
                 */
                if ( jZeroToH+(sizeInterArray-1)*h >= nItems )
                {
                    sizeInterArray--;
                }

                // 内部用插入排序
                // 最大有sizeInterArray个元素有待排序
                for ( int i = 1; i < sizeInterArray; i++ )
                // 总共有sizeInterArray个元素有待排序，所以循环sizeInterArray次
                {
                    out = jZeroToH + i * h;
                    temp = intArray[out];
                    in = out;
                    while ( in > h-1 && intArray[in - h] > temp )
                    {
                        intArray[in] = intArray[in-h];
                        in = in - h;
                    }
                    intArray[in] = temp;
                }
            }
            System.out.print(iIntervalLength + " : h=" + h + " ");
            this.displayArray();
        }
    }

    // 插入一个元素到待排序数组
    public void insert( int value )
    {
        if ( nItems < maxItems )
        {
            intArray[nItems] = value;
            nItems++ ;
        } else
        {
            System.out.println( "The array is full!" );
        }
    }

    //初始化待排序数组
    public void initArray( int[] array )
    {
        for ( int i = 0; i < array.length; i++ )
        {
            intArray[i] = array[i];
        }
        nItems = array.length;
    }

    //用随机数初始化
    public void initRandom()
    {
        nItems = 0;
        for ( int i = 0; i < maxItems; i++ )
        {
            int n = (int) ( java.lang.Math.random( ) * maxItems );
            insert( n );
        }
    }

    // 显示数组内容
    public void displayArray()
    {
        System.out.print( "\t" );
        for ( int i = 0; i < nItems; i++ )
        {
            System.out.print( intArray[i] + " " );
        }
        System.out.println( "" );
    }

}
