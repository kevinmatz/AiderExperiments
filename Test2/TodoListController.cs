using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace TodoList.Controllers
{
    public class TodoListController : Controller
    {
        // This will be replaced with actual data from database
        private List<string> TodoItems = new List<string>();

        public IActionResult Index()
        {
            return View(TodoItems);
        }
    }
}
