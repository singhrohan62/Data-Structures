

void selectionSort(int arr[], int n) {

      int i, j, minIndex, dummy;    

      for (i = 0; i < n - 1; i++) {

            minIndex = i;

            for (j = i + 1; j < n; j++)

                  if (arr[j] < arr[minIndex])

                        minIndex = j;

            if (minIndex != i) {

                  dummy = arr[i];

                  arr[i] = arr[minIndex];

                  arr[minIndex] = dummy;

            }

      }

}