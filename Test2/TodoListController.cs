using Microsoft.AspNetCore.Mvc;
using System.Linq;
using TodoList.Data;
using TodoList.Models;

namespace TodoList.Controllers
{
    public class TodoListController : Controller
    {
        private readonly TodoListContext _context;

        public TodoListController(TodoListContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            var todoItems = _context.TodoItems.ToList();
            return View(todoItems);
        }
    }
}
