static int UtopianTree(int cycles)
{
    int height = 0;

    for (int i = 0; i <= cycles; i++)
    {
        if (i == 0 || i % 2 == 0)
            height += 1;
        else if (i % 2 == 1)
            height *= 2;
    }

    return height;
}

Console.WriteLine(UtopianTree(0));
Console.WriteLine(UtopianTree(1));
Console.WriteLine(UtopianTree(2));
Console.WriteLine(UtopianTree(3));
Console.WriteLine(UtopianTree(4));
Console.WriteLine(UtopianTree(5));
Console.WriteLine(UtopianTree(8));
Console.WriteLine(UtopianTree(13));
Console.WriteLine(UtopianTree(60));
