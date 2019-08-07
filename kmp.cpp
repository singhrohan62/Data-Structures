#include <bits/stdc++.h>

using namespace std;

void implementAuxArray(int* ptr, string pattern, int patLen)
{
	int m = 0;
	int i = 1;
	while(i  < patLen)
	{
		if (pattern.at(i) == pattern.at(m))
		{
			m++;
			ptr[i] = m;
			i++;
		}
		else if (pattern.at(i) != pattern.at(m) && m != 0)
		{
			m = ptr[m-1];
		}
		else
			i++;
	}
}

int main()
{
	string input="acabacaba", output="acfacabacabacacdk";

	//cin >> input >> output;

	string text = input, pattern = output;

	if(input.length() < output.length())
	{
		text = output;
		pattern = input;
	}
	int patLen = pattern.length();

	int aux[patLen] = {};

	int *auxPtr = aux;

	implementAuxArray(auxPtr, pattern, patLen);

	for (int i = 0; i < patLen; ++i)
	{
		cout << auxPtr[i] <<" ";
	}
	cout << endl << text << " " << pattern << endl;

	int textIndex = 0,patIndex = 0, patLenMatching = 0;

	while(textIndex < text.length())
	{
		if( text.at(textIndex) != pattern.at(patIndex))
		{
			if(patIndex == 0)
			{
				textIndex++;
			}
			else
			{
				patIndex = auxPtr[patIndex-1];
			}
		}
		else
		{
			textIndex++;
			patIndex++;
			if(patLenMatching < patIndex)
				patLenMatching = patIndex;
			if(patIndex == patLen) break;
		}
	}

	if(patIndex == patLen)
		cout << "Eureka! pattern existing in the given text" << endl;
	else
	cout << "minimum number of operations to perform for converting text to pattern: "<< text.length() - patLenMatching << endl;
	//cout << "patIndex: "<<patIndex<<", patLenMatching: "<<patLenMatching<<endl;

	return 0;
}