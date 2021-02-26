val calendar = createCalendar().run {
    selectCurrentDay()
    print("$day $month $year")
}