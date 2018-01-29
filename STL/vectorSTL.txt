#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> ///For accumulate
using namespace std;

int main()
{   ///Initializing vector directly with array
    static const int arr[]={1,4,3,6,2,7};
    vector<int> vect(arr,arr+sizeof(arr)/sizeof(arr[0]));
    ///STL#1 - SORTING
    for(int i=0;i<vect.size();i++)
        cout<<vect.at(i)<<" ";
    cout<<endl;
    sort(vect.begin(),vect.end());
    for(int i=0;i<vect.size();i++)
        cout<<vect.at(i)<<" ";
    cout<<endl;
    ///STL#2 - REVERSE
    reverse(vect.begin(),vect.end());
    for(int i=0;i<vect.size();i++)
        cout<<vect.at(i)<<" ";
    cout<<endl;
    ///STL#3 -Max and Min element
    cout<<*max_element(vect.begin(),vect.end())<<endl<<*min_element(vect.begin(),vect.end())<<endl;
    ///STL#4 -Accumulate
    cout<<accumulate(vect.begin(),vect.end(),0)<<endl;
    ///STL#5 -Count Occurrence of an element
    cout<<count(vect.begin(),vect.end(),2)<<endl;
    ///STL#6 -Find
    find(vect.begin(),vect.end(),5)!=vect.end()?cout<<"FOUND"<<" ":cout<<"NOT FOUND"<<endl;
    ///STL#7 -BinarySearch
    cout<<binary_search(vect.begin(),vect.end(),2)<<endl;
    ///STL#8 -UpperBound and LowerBound
    ///Returns the first occurrence of 20

    vector<int> :: iterator low,up;
    low=lower_bound(vect.begin(),vect.end(),3);///This will return the first occurrence of 3
    up=upper_bound(vect.begin(),vect.end(),1);///This will return last occurrence of 1

    cout << "The lower bound is at position: ";
    cout << low-vect.begin() << endl;  ///THE FIRST OCCURRENCE OF 3
    cout << "The upper bound is at position: ";
    cout << p-vect.begin() << endl; ///THE LAST OCCURRENCE OF 1

    ///STL#9 -arr.erase(position to be deleted):This erases selected element in vector and shifts and resizes the vector elements accordingly.
    vect.erase(vect.begin()+1);
    for(int i=0;i<vect.size();i++)
        cout<<vect.at(i)<<" ";
    cout<<endl;
    ///STL#10 -distance(): It returns the distance of desired position from the first iterator.This function is very useful while finding the index
    cout<<distance(vect.begin(),min_element(vect.begin(),vect.end()))<<endl;

    return 0;
}
